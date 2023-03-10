package com.eduardo.vendas.service.impl;

import com.eduardo.vendas.domain.Cliente;
import com.eduardo.vendas.domain.ItemPedido;
import com.eduardo.vendas.domain.Pedido;
import com.eduardo.vendas.domain.Produto;
import com.eduardo.vendas.domain.dto.ItemPedidoDTO;
import com.eduardo.vendas.domain.dto.PedidoDTO;
import com.eduardo.vendas.service.exception.RegraNegocioException;
import com.eduardo.vendas.repository.ClienteRepository;
import com.eduardo.vendas.repository.ItemPedidoRepository;
import com.eduardo.vendas.repository.PedidoRepository;
import com.eduardo.vendas.repository.ProdutoRepository;
import com.eduardo.vendas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO pedidoDTO) {
        Integer idCliente = pedidoDTO.getCliente();
        Cliente cliente = clienteRepository.findById(idCliente)
                                           .orElseThrow(() -> new RegraNegocioException("Código de cliente inválido!"));


        Pedido pedido = new Pedido();
        pedido.setTotal(pedidoDTO.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itemsPedidos = converterItems(pedido, pedidoDTO.getItems());
        pedidoRepository.save(pedido);
        itemPedidoRepository.saveAll(itemsPedidos);
        pedido.setItens(itemsPedidos);
        return pedido;
    }

    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items) {
        if(items.isEmpty()){
            throw new RegraNegocioException("Não é possível realizar um pedido sem items!");
        }

        return items.stream()
                    .map(dto -> {
                        Integer idProduto = dto.getProduto();
                        Produto produto = produtoRepository.findById(idProduto)
                                                           .orElseThrow(() -> new RegraNegocioException("Código de produto inválido! " + idProduto));

                        ItemPedido itemPedido = new ItemPedido();
                        itemPedido.setQuantidade(dto.getQuantidade());
                        itemPedido.setPedido(pedido);
                        itemPedido.setProduto(produto);
                        return itemPedido;
                    }).collect(Collectors.toList());
    }
}
