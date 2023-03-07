package com.eduardo.vendas.controller;

import com.eduardo.vendas.domain.Cliente;
import com.eduardo.vendas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Cliente>> getClienteById(@PathVariable Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
          return ResponseEntity.ok().body(cliente);
        }
        return ResponseEntity.notFound().build();
    }
}
