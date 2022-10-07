package com.github.antonioticelso.lojademo.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data = LocalDate.now();

    @ManyToOne
    private Cliente cliente;

    @Column(name = "valor_total")
    private BigDecimal valorTotal = BigDecimal.ZERO;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> items = new ArrayList<>();

    public void adicionarItem(ItemPedido itemPedido) {
        itemPedido.setPedido(this);
        this.items.add(itemPedido);
        this.valorTotal = this.valorTotal.add(itemPedido.getValor());

    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

}
