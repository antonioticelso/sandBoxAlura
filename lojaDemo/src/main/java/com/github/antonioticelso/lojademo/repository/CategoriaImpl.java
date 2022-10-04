package com.github.antonioticelso.lojademo.repository;

import com.github.antonioticelso.lojademo.modelo.Categoria;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;

@AllArgsConstructor
public class CategoriaImpl {

    private EntityManager manager;

    public void cadastrar(Categoria categoria) {
        this.manager.persist(categoria);
    }

    public void atualizar(Categoria categoria) {
        this.manager.merge(categoria);
    }

    public void remover(Categoria categoria) {
        atualizar(categoria);
        this.manager.remove(categoria);
    }

}
