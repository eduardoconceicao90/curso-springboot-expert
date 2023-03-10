package com.eduardo.vendas.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class InformacaoItemPedidoDTO {

    private String descricaoProduto;
    private BigDecimal precoUnitario;
    private Integer quantidade;
}
