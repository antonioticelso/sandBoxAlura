package com.github.antonioticelso.lojademo;

import com.github.antonioticelso.lojademo.modelo.Produto;
import com.github.antonioticelso.lojademo.repository.ProdutoImpl;
import com.github.antonioticelso.lojademo.util.JPAUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

//@SpringBootApplication
public class LojaDemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(LojaDemoApplication.class, args);
		Produto celular = new Produto();
		celular.setName("Xiaomi Redmi Pro 8");
		celular.setDescricao("Muito bom mesmo");
		celular.setPreco(new BigDecimal("800"));

		EntityManager manager = JPAUtil.getEntityManager();

		ProdutoImpl impl = new ProdutoImpl(manager);

		manager.getTransaction().begin();
		impl.cadastrar(celular);
		manager.getTransaction().commit();
		manager.close();

	}

}
