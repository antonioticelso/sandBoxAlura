package com.github.antonioticelso.lojademo;

import com.github.antonioticelso.lojademo.modelo.Categoria;
import com.github.antonioticelso.lojademo.modelo.Produto;
import com.github.antonioticelso.lojademo.repository.CategoriaImpl;
import com.github.antonioticelso.lojademo.repository.ProdutoImpl;
import com.github.antonioticelso.lojademo.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

//@SpringBootApplication
public class LojaDemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(LojaDemoApplication.class, args);
		EntityManager manager = JPAUtil.getEntityManager();

		ProdutoImpl produtoImpl = new ProdutoImpl(manager);
		CategoriaImpl categoriaImpl = new CategoriaImpl(manager);

		Categoria celulares = new Categoria();
		celulares.setNome("CELULARES");

		Produto celular = new Produto();
		celular.setName("Xiaomi Redmi Pro 8");
		celular.setDescricao("Muito bom mesmo");
		celular.setPreco(new BigDecimal("800"));


		manager.getTransaction().begin();

		categoriaImpl.cadastrar(celulares);
		produtoImpl.cadastrar(celular);

		manager.getTransaction().commit();
		manager.close();

	}

}
