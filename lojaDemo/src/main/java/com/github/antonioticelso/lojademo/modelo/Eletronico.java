package com.github.antonioticelso.lojademo.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "eletronicos")
public class Eletronico extends Produto {

    private String marca;
    private String modelo;


}
