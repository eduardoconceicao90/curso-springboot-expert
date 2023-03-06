package com.eduardo.vendas;

import com.eduardo.vendas.domain.Cliente;
import com.eduardo.vendas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired ClienteRepository clienteRepository){
		return args -> {
			System.out.println("Salvando clientes");
			clienteRepository.save(new Cliente("Eduardo"));
			clienteRepository.save(new Cliente("Telma"));

			List<Cliente> todosClientes = clienteRepository.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("Atualizando clientes");
			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + " atualizado.");
				clienteRepository.save(c);
			});

			todosClientes = clienteRepository.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("Buscando clientes");
			clienteRepository.findByNomeLike("Edu").forEach(System.out::println);

			System.out.println("Deletando clientes");
			clienteRepository.findAll().forEach(c -> {
				clienteRepository.delete(c);
			});

			todosClientes = clienteRepository.findAll();

			if(todosClientes.isEmpty()){
				System.out.println("Nenhum cliente encontrado.");
			} else {
				todosClientes.forEach(System.out::println);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
