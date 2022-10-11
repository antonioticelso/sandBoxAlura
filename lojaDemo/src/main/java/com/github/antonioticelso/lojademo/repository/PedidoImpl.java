package com.github.antonioticelso.lojademo.repository;

import com.github.antonioticelso.lojademo.modelo.Pedido;
import com.github.antonioticelso.lojademo.modelo.vo.RelatorioDeVendasVo;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
public class PedidoImpl {

    private EntityManager manager;

    public void cadastrar(Pedido pedido) {
        this.manager.persist(pedido);
    }

    public void atualizar(Pedido pedido) {
        this.manager.merge(pedido);
    }

    public BigDecimal valorTotalVendido() {
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
        return manager.createQuery(jpql, BigDecimal.class).getSingleResult();
    }

    public List<RelatorioDeVendasVo> relatorioDeVendas() {
        String jpql = "SELECT new com.github.antonioticelso.lojademo.modelo.vo.RelatorioDeVendasVo(" +
                "produto.name, SUM(item.quantidade), MAX(pedido.data), categoria.nome)" +
                " FROM Pedido pedido JOIN pedido.items item JOIN item.produto produto JOIN produto.categoria categoria" +
                " GROUP BY produto.name ORDER BY item.quantidade DESC";
        return manager.createQuery(jpql, RelatorioDeVendasVo.class).getResultList();

    }

    public Pedido buscarPedidoComCliente(Long id) {
        String jpql = "SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = ?1";
        return manager.createQuery(jpql, Pedido.class)
                .setParameter(1, id)
                .getSingleResult();
    }

//    public void remover(Produto produto) {
//        atualizar(produto);
//        this.manager.remove(produto);
//    }
//
//    public Produto buscarPorId(Long id) {
//       return manager.find(Produto.class, id);
//    }
//
//    public List<Produto> listAll() {
//        String jpql = "SELECT p FROM Produto p";
//        return manager.createQuery(jpql, Produto.class).getResultList();
//    }
//
//    public List<Produto> buscarPorNome(String nome) {
////        String jpql = "SELECT p FROM Produto p WHERE p.name = ?1";
//        String jpql = "SELECT p FROM Produto p WHERE p.name = :nome";
//        return manager.createQuery(jpql, Produto.class)
//                .setParameter("nome", nome)
//                .getResultList();
//    }
//


}
