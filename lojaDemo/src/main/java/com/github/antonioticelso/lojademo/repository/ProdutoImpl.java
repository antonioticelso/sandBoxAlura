package com.github.antonioticelso.lojademo.repository;

import com.github.antonioticelso.lojademo.modelo.Produto;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;

@AllArgsConstructor
public class ProdutoImpl {

    private EntityManager manager;

    public void cadastrar(Produto produto) {
        this.manager.persist(produto);
    }

}
