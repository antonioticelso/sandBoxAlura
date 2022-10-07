package com.github.antonioticelso.lojademo.repository;

import com.github.antonioticelso.lojademo.modelo.Cliente;
import com.github.antonioticelso.lojademo.modelo.Pedido;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;

@AllArgsConstructor
public class ClienteImpl {

    private EntityManager manager;

    public void cadastrar(Cliente cliente) {
        this.manager.persist(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return manager.find(Cliente.class, id);
    }

//    public void atualizar(Cliente pedido) {
//        this.manager.merge(pedido);
//    }
//    public void remover(Produto produto) {
//        atualizar(produto);
//        this.manager.remove(produto);
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
