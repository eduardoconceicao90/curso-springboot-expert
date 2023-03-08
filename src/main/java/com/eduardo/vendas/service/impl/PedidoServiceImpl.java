package com.eduardo.vendas.service.impl;

import com.eduardo.vendas.repository.PedidoRepository;
import com.eduardo.vendas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
}
