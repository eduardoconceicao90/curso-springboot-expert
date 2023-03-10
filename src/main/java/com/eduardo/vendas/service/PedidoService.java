package com.eduardo.vendas.service;

import com.eduardo.vendas.domain.Pedido;
import com.eduardo.vendas.domain.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {

    Pedido salvar(PedidoDTO pedidoDTO);

    Optional<Pedido> obterPedidoCompleto(Integer id);
}
