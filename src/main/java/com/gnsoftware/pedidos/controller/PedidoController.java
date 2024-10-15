package com.gnsoftware.pedidos.controller;

import com.gnsoftware.pedidos.domain.Pedido;
import com.gnsoftware.pedidos.dto.PedidoResponseDTO;
import com.gnsoftware.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public Pedido criarPedidoComProdutos(@RequestBody Pedido pedido) {
        return pedidoService.criarPedidoComProdutos(pedido);

    }


    @GetMapping("/{id}")
    public PedidoResponseDTO buscarPedidoComProdutos(@PathVariable Long id) {
        return pedidoService.buscarPedidoComProdutos(id);
    }

    //http://localhost:8080/pedidos
    @GetMapping
    public List<PedidoResponseDTO> retornaTodosPedidosComProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.buscarTodosPedidosComProdutos()).getBody();
    }
}
