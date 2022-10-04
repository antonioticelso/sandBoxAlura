package com.github.antonioticelso.lojademo;

import com.github.antonioticelso.lojademo.modelo.Categoria;
import com.github.antonioticelso.lojademo.modelo.Produto;
import com.github.antonioticelso.lojademo.repository.CategoriaImpl;
import com.github.antonioticelso.lojademo.repository.ProdutoImpl;
import com.github.antonioticelso.lojademo.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

//@SpringBootApplication
public class LojaDemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(LojaDemoApplication.class, args);
		cadastrarProduto();
		EntityManager manager = JPAUtil.getEntityManager();
		ProdutoImpl produtoImpl = new ProdutoImpl(manager);

		Produto p = produtoImpl.buscarPorId(1l);
		System.out.println(p.getName() + " - " + p.getPreco()+ " - " + p.getCategoria());

		List<Produto> list = produtoImpl.listAll();
		list.forEach(pr -> System.out.println(pr.getName()));

		List<Produto> todos = produtoImpl.buscarPorNome("Xiaomi Redmi Pro 8");
		list.forEach(pr -> System.out.println(pr.getName()));

		List<Produto> todaCategoria = produtoImpl.buscarPorNomeCategoria("Xiaomi Redmi Pro 8");
		list.forEach(pr -> System.out.println(pr.getName()));

	}

	private static void cadastrarProduto() {
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
