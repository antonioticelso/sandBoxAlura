package com.github.antonioticelso.lojademo.repository;

import com.github.antonioticelso.lojademo.modelo.Categoria;
import com.github.antonioticelso.lojademo.modelo.Produto;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@AllArgsConstructor
public class ProdutoImpl {

    private EntityManager manager;

    public void cadastrar(Produto produto) {
        this.manager.persist(produto);
    }

    public void atualizar(Produto produto) {
        this.manager.merge(produto);
    }

    public void remover(Produto produto) {
        atualizar(produto);
        this.manager.remove(produto);
    }

    public Produto buscarPorId(Long id) {
       return manager.find(Produto.class, id);
    }

    public List<Produto> listAll() {
        String jpql = "SELECT p FROM Produto p";
        return manager.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String nome) {
//        String jpql = "SELECT p FROM Produto p WHERE p.name = ?1";
        String jpql = "SELECT p FROM Produto p WHERE p.name = :nome";
        return manager.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> buscarPorNomeCategoria(String nome) {
//        String jpql = "SELECT p FROM Produto p WHERE p.name = ?1";
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
        return manager.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

}
