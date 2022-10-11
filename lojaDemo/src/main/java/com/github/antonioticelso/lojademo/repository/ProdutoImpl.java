package com.github.antonioticelso.lojademo.repository;

import com.github.antonioticelso.lojademo.modelo.Categoria;
import com.github.antonioticelso.lojademo.modelo.Produto;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;
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
        String jpql = "SELECT p FROM Produto p WHERE p.name = :nome";
        return manager.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public BigDecimal buscarNomeEDataProduto(String nome) {
        String jpql = "SELECT p.preco FROM Produto p WHERE p.name = :nome";
        return manager.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }

    public List<Produto> buscarPorParametros(String name, BigDecimal preco, LocalDate dataCadastro) {
        String jpql = "SELECT p.preco FROM Produto p WHERE 1=1";
        if (name != null && !name.trim().isEmpty()) {
            jpql += " AND p.name = :nome";
        }
        if (preco != null) {
            jpql += " AND p.preco = :preco";
        }
        if (dataCadastro != null) {
            jpql += " AND p.dataCadastro = :dataCadastro";
        }

        TypedQuery<Produto> query = manager.createQuery(jpql, Produto.class);
        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        if (preco != null) {
            query.setParameter("preco", preco);
        }
        if (dataCadastro != null) {
            query.setParameter("dataCadastro", dataCadastro);
        }

        return query.getResultList();

    }

    public List<Produto> buscarPorParametrosOpcionais(String name, BigDecimal preco, LocalDate dataCadastro) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> from = query.from(Produto.class);
        Predicate filtos = builder.and();

        if (name != null && !name.trim().isEmpty()) {
            filtos = builder.and(filtos, builder.equal(from.get("name"), name));
        }
        if (preco != null) {
            filtos = builder.and(filtos, builder.equal(from.get("preco"), preco));
        }
        if (dataCadastro != null) {
            filtos = builder.and(filtos, builder.equal(from.get("dataCadastro"), dataCadastro));
        }

        query.where(filtos);

        return manager.createQuery(query).getResultList();

    }




}
