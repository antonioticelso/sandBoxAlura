package com.github.antonioticelso.lojademo;

import com.github.antonioticelso.lojademo.modelo.*;
import com.github.antonioticelso.lojademo.modelo.vo.RelatorioDeVendasVo;
import com.github.antonioticelso.lojademo.repository.CategoriaImpl;
import com.github.antonioticelso.lojademo.repository.ClienteImpl;
import com.github.antonioticelso.lojademo.repository.PedidoImpl;
import com.github.antonioticelso.lojademo.repository.ProdutoImpl;
import com.github.antonioticelso.lojademo.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

//@SpringBootApplication
public class LojaDemoApplicationPerformance {

	public static void main(String[] args) {
//		SpringApplication.run(LojaDemoApplication.class, args);
		popolarDB();
		EntityManager manager = JPAUtil.getEntityManager();

		Pedido pedido = manager.find(Pedido.class, 1l);
		System.out.println(pedido.getData());
		System.out.println(pedido.getItems().size());

		PedidoImpl pedidoImpl = new PedidoImpl(manager);
		Pedido pedido1 = pedidoImpl.buscarPedidoComCliente(1l);

		manager.close();

		System.out.println(pedido1.getCliente().getNome() + " - " + pedido1.getCliente().getCpf());

	}

	private static void popolarDB() {
		cadastrarProduto();
		EntityManager manager = JPAUtil.getEntityManager();

		ProdutoImpl produtoImpl = new ProdutoImpl(manager);
		ClienteImpl clienteImpl = new ClienteImpl(manager);
		PedidoImpl pedidoImpl = new PedidoImpl(manager);

		Produto produto = produtoImpl.buscarPorId(1l);
		Produto produto3 = produtoImpl.buscarPorId(3l);
		Produto produto4 = produtoImpl.buscarPorId(4l);
		Cliente cliente = clienteImpl.buscarPorId(1l);

		manager.getTransaction().begin();

		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		pedido.adicionarItem(new ItemPedido(30, pedido, produto3));

		Pedido pedido2 = new Pedido(cliente);
		pedido2.adicionarItem(new ItemPedido(50, pedido, produto4));

		pedidoImpl.cadastrar(pedido);
		pedidoImpl.cadastrar(pedido2);

		manager.getTransaction().commit();

		BigDecimal totalVendido = pedidoImpl.valorTotalVendido();
		System.out.println("Valor total vendido: " + totalVendido);

		List<RelatorioDeVendasVo> relatorioVendas = pedidoImpl.relatorioDeVendas();
		relatorioVendas.forEach(System.out::println);

		manager.close();
	}

	private static void cadastrarProduto() {
		EntityManager manager = JPAUtil.getEntityManager();

		ProdutoImpl produtoImpl = new ProdutoImpl(manager);
		CategoriaImpl categoriaImpl = new CategoriaImpl(manager);
		ClienteImpl clienteImpl = new ClienteImpl(manager);

		Categoria celulares = new Categoria("CELULARES");
		Categoria eletronicos = new Categoria("ELETRONICOS");
		Categoria eletrodomesticos = new Categoria("ELETRODOMESTICOS");

		Cliente cliente = new Cliente("Tonhao", "1234566");
		clienteImpl.cadastrar(cliente);

		Produto celular = new Produto();
		celular.setName("Xiaomi Redmi Pro 8");
		celular.setDescricao("Muito bom mesmo");
		celular.setPreco(new BigDecimal("800"));
		celular.setCategoria(celulares);

		Produto celular2 = new Produto();
		celular2.setName("Xiaomi Redmi");
		celular2.setDescricao("Muito bom");
		celular2.setPreco(new BigDecimal("650"));
		celular2.setCategoria(celulares);

		Produto videogame = new Produto();
		videogame.setName("XBox 360");
		videogame.setDescricao("Muito top");
		videogame.setPreco(new BigDecimal("1650"));
		videogame.setCategoria(eletronicos);

		Produto nootbox = new Produto();
		nootbox.setName("Dell Inspere");
		nootbox.setDescricao("Muito top ao cubo");
		nootbox.setPreco(new BigDecimal("7650"));
		nootbox.setCategoria(eletronicos);

		Produto geladeira = new Produto();
		geladeira.setName("Eletrolux");
		geladeira.setDescricao("Muito boa");
		geladeira.setPreco(new BigDecimal("2500"));
		geladeira.setCategoria(eletrodomesticos);



		manager.getTransaction().begin();

		categoriaImpl.cadastrar(celulares);
		categoriaImpl.cadastrar(eletronicos);
		categoriaImpl.cadastrar(eletrodomesticos);
		produtoImpl.cadastrar(celular);
		produtoImpl.cadastrar(celular2);
		produtoImpl.cadastrar(videogame);
		produtoImpl.cadastrar(nootbox);
		produtoImpl.cadastrar(geladeira);

		manager.getTransaction().commit();
		manager.close();
	}

}
