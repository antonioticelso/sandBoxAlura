package com.github.antonioticelso.lojademo.repository;

import com.github.antonioticelso.lojademo.modelo.Categoria;
import com.github.antonioticelso.lojademo.modelo.Produto;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;

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

}
