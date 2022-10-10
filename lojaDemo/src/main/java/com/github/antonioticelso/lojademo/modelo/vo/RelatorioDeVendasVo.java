package com.github.antonioticelso.lojademo.modelo.vo;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
public class RelatorioDeVendasVo {

    private String nomeProduto;
    private Long quantidadeItem;
    private LocalDate dataPedido;
    private String nomeCategoria;

    public RelatorioDeVendasVo(String nomeProduto, Long quantidadeItem, LocalDate dataPedido, String nomeCategoria) {
        this.nomeProduto = nomeProduto;
        this.quantidadeItem = quantidadeItem;
        this.dataPedido = dataPedido;
        this.nomeCategoria = nomeCategoria;
    }

}
