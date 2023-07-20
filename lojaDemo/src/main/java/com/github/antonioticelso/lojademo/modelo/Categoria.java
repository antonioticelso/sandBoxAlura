package com.github.antonioticelso.lojademo.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Categoria {

    @EmbeddedId
    private CategoriaId id;

    public Categoria(String nome) {

        this.id = new CategoriaId(nome, "xpto");
    }

    public String getNome() {

        return this.id.getNome();
    }

}
