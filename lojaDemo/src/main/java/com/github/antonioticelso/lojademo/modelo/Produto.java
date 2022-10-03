package com.github.antonioticelso.lojademo.modelo;

import com.github.antonioticelso.lojademo.util.Categoria;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "produtos")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String descricao;
    private BigDecimal preco;
    private LocalDate dataCadastro = LocalDate.now();
    private LocalDate dataUpdate = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

}
