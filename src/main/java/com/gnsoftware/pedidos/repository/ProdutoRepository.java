package com.gnsoftware.pedidos.repository;

import com.gnsoftware.pedidos.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
