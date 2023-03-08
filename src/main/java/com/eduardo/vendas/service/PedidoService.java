package com.eduardo.vendas.service;

import com.eduardo.vendas.domain.Pedido;
import com.eduardo.vendas.domain.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO pedidoDTO);
}
