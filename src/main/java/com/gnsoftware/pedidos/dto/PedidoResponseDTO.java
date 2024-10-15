package com.gnsoftware.pedidos.dto;

import com.gnsoftware.pedidos.domain.Pedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PedidoResponseDTO {

    private Long pedidoId;
    private String descricao;
    private List<ProdutoQuantidadeDTO> produtos = new ArrayList<>();

    public PedidoResponseDTO(Pedido pedido,List<ProdutoQuantidadeDTO> produtos) {
        this.pedidoId = pedido.getId();
        this.descricao = pedido.getDescricao();
        this.produtos = produtos;
    }

}
