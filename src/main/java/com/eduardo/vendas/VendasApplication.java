package com.eduardo.vendas;

import com.eduardo.vendas.domain.Cliente;
import com.eduardo.vendas.domain.Pedido;
import com.eduardo.vendas.repository.ClienteRepository;
import com.eduardo.vendas.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired ClienteRepository clienteRepository,
			@Autowired PedidoRepository pedidoRepository){
		return args -> {
			System.out.println("Salvando clientes");
			Cliente c1 = new Cliente("Fulano");
			clienteRepository.save(c1);

			Pedido p = new Pedido();
			p.setCliente(c1);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100));
			pedidoRepository.save(p);

//			Cliente cliente = clienteRepository.findClienteFetchPedidos(c1.getId());
//			System.out.println(cliente);
//			System.out.println(cliente.getPedidos());

			pedidoRepository.findByCliente(c1).forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
