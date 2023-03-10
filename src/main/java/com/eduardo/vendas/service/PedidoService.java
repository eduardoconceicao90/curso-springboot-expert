package com.eduardo.vendas.service;

import com.eduardo.vendas.domain.Pedido;
import com.eduardo.vendas.domain.dto.PedidoDTO;
import com.eduardo.vendas.domain.enums.StatusPedido;

import java.util.Optional;

public interface PedidoService {

    Pedido salvar(PedidoDTO pedidoDTO);

    Optional<Pedido> obterPedidoCompleto(Integer id);

    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
