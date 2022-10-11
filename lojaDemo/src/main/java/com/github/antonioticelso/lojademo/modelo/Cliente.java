package com.github.antonioticelso.lojademo.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Pessoa pessoa;

    public Cliente(String nome, String cpf) {
        this.pessoa = new Pessoa(nome, cpf);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getNome() {
        return this.pessoa.getNome();
    }

    public String getCpf() {
        return this.pessoa.getCpf();
    }

}
