package com.eduardo.vendas.controller;

import com.eduardo.vendas.domain.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

    @RequestMapping(
            value = "/hello/{nome}",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"}
    )
    @ResponseBody
    public Cliente helloCliente(@PathVariable("nome") String nomeCliente, @ResponseBody Cliente cliente){
        return String.format("Hello %s", nomeCliente);
    }
}
