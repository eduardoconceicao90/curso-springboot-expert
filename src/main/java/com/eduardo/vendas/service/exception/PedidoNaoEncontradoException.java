package com.eduardo.vendas.service.exception;

public class PedidoNaoEncontradoException extends RuntimeException {

    public PedidoNaoEncontradoException() {
        super("Pedido não encontrado!");
    }
}
