package com.gnsoftware.pedidos.service;

import com.gnsoftware.pedidos.domain.Pedido;
import com.gnsoftware.pedidos.domain.PedidoProduto;
import com.gnsoftware.pedidos.domain.Produto;
import com.gnsoftware.pedidos.dto.PedidoResponseDTO;
import com.gnsoftware.pedidos.dto.ProdutoQuantidadeDTO;
import com.gnsoftware.pedidos.repository.PedidoProdutoRepository;
import com.gnsoftware.pedidos.repository.PedidoRepository;
import com.gnsoftware.pedidos.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;

    private final PedidoProdutoRepository pedidoProdutoRepository;


    public Pedido criarPedidoComProdutos(Pedido pedido) {

        Pedido novoPedido = pedidoRepository.save(pedido);

        for (ProdutoQuantidadeDTO dto : pedido.getProdutos()) {

            Produto produto = produtoRepository.findById(dto.getProdutoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            PedidoProduto pedidoProduto = new PedidoProduto(novoPedido, produto, dto.getQuantidade());
            pedidoProdutoRepository.save(pedidoProduto); //aqui salva a associação
        }

        return novoPedido;
    }

    public PedidoResponseDTO buscarPedidoComProdutos(Long pedidoId) {

        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        List<ProdutoQuantidadeDTO> produtos = pedido.getPedidoProdutos().stream()
                .map(pedidoProduto -> new ProdutoQuantidadeDTO(
                        pedidoProduto.getProduto(),
                        pedidoProduto.getQuantidade()
                ))
                .collect(Collectors.toList());


        return new PedidoResponseDTO(pedido,produtos);
    }
    public List<PedidoResponseDTO> buscarTodosPedidosComProdutos() {
        List<Pedido> pedidos = pedidoRepository.findAll();

        return pedidos.stream().map(pedido -> {
            List<ProdutoQuantidadeDTO> produtos = pedido.getPedidoProdutos().stream()
                    .map(pedidoProduto -> new ProdutoQuantidadeDTO(
                            pedidoProduto.getProduto(),
                            pedidoProduto.getQuantidade()
                    ))
                    .collect(Collectors.toList());

            return new PedidoResponseDTO(pedido, produtos);
        }).collect(Collectors.toList());
    }
}
