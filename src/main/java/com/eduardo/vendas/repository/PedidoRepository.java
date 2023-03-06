package com.eduardo.vendas.repository;

import com.eduardo.vendas.domain.Cliente;
import com.eduardo.vendas.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);
}
