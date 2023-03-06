package com.eduardo.vendas.repository;

import com.eduardo.vendas.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
