package com.github.antonioticelso.lojademo;

import com.github.antonioticelso.lojademo.modelo.*;
import com.github.antonioticelso.lojademo.repository.CategoriaImpl;
import com.github.antonioticelso.lojademo.repository.ClienteImpl;
import com.github.antonioticelso.lojademo.repository.PedidoImpl;
import com.github.antonioticelso.lojademo.repository.ProdutoImpl;
import com.github.antonioticelso.lojademo.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//@SpringBootApplication
public class LojaDemoApplicationPedido {

	public static void main(String[] args) {
//		SpringApplication.run(LojaDemoApplication.class, args);
		cadastrarProduto();
		EntityManager manager = JPAUtil.getEntityManager();
		ProdutoImpl produtoImpl = new ProdutoImpl(manager);
		Produto produto = produtoImpl.buscarPorId(1l);

		ClienteImpl clienteImpl = new ClienteImpl(manager);
		Cliente cliente = clienteImpl.buscarPorId(1l);

		manager.getTransaction().begin();

		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));

		PedidoImpl pedidoImp = new PedidoImpl(manager);
		pedidoImp.cadastrar(pedido);

		manager.getTransaction().commit();

		BigDecimal totalVendido = pedidoImp.valorTotalVendido();
		System.out.println("Valor total vendido: " + totalVendido);

		manager.close();


	}

	private static void cadastrarProduto() {
		EntityManager manager = JPAUtil.getEntityManager();

		ProdutoImpl produtoImpl = new ProdutoImpl(manager);
		CategoriaImpl categoriaImpl = new CategoriaImpl(manager);
		ClienteImpl clienteImp = new ClienteImpl(manager);

		Categoria celulares = new Categoria();
		celulares.setNome("CELULARES");

		Cliente cliente = new Cliente("Tonhao", "1234566");
		clienteImp.cadastrar(cliente);

		Produto celular = new Produto();
		celular.setName("Xiaomi Redmi Pro 8");
		celular.setDescricao("Muito bom mesmo");
		celular.setPreco(new BigDecimal("800"));

		Produto celular2 = new Produto();
		celular2.setName("Xiaomi Redmi");
		celular2.setDescricao("Muito bom");
		celular2.setPreco(new BigDecimal("650"));

		manager.getTransaction().begin();

		categoriaImpl.cadastrar(celulares);
		produtoImpl.cadastrar(celular);
		produtoImpl.cadastrar(celular2);

		manager.getTransaction().commit();
		manager.close();
	}

}
