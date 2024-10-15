package com.gnsoftware.pedidos.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private Integer quantidade;

    public PedidoProduto(Pedido novoPedido, Produto produto, Integer quantidade) {
        this.pedido = novoPedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }
}
