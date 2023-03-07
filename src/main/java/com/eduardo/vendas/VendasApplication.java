package com.eduardo.vendas;

import com.eduardo.vendas.domain.Cliente;
import com.eduardo.vendas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner commandLineRunner(@Autowired ClienteRepository clienteRepository){
		return args -> {
			Cliente c = new Cliente(null, "Fulano");
			clienteRepository.save(c);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
