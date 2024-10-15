package com.gnsoftware.pedidos.dto;

import com.gnsoftware.pedidos.domain.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoQuantidadeDTO {

    private Long produtoId;
    private String nome;

    private Integer quantidade;

    public ProdutoQuantidadeDTO(Produto produto,Integer quantidade) {
        this.produtoId = produto.getId();
        this.nome = produto.getNome();
        this.quantidade = quantidade;
    }


}
