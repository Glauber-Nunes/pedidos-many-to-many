package com.gnsoftware.pedidos.repository;

import com.gnsoftware.pedidos.domain.PedidoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto,Long> {
}
