package com.gnsoftware.pedidos.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gnsoftware.pedidos.dto.ProdutoQuantidadeDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<PedidoProduto> pedidoProdutos = new HashSet<>();

    @Transient
    private List<ProdutoQuantidadeDTO> produtos = new ArrayList<>();
}
