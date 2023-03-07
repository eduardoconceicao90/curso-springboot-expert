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
    public ResponseEntity getClienteById(@PathVariable Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()){
          return ResponseEntity.ok().body(cliente);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Cliente cliente){
        Cliente newObj = clienteRepository.save(cliente);
        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()){
           clienteRepository.deleteById(id);
           return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Cliente cliente){
        return clienteRepository.findById(id)
                                .map(clienteExistente -> {
                                    cliente.setId(clienteExistente.getId());
                                    clienteRepository.save(cliente);
                                    return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
