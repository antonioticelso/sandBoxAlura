package com.github.antonioticelso.lojademo.repository;

import com.github.antonioticelso.lojademo.modelo.Pedido;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

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
//    public BigDecimal buscarNomeEDataProduto(String nome) {
//        String jpql = "SELECT p.preco FROM Produto p WHERE p.name = :nome";
//        return manager.createQuery(jpql, BigDecimal.class)
//                .setParameter("nome", nome)
//                .getSingleResult();
//    }


}
