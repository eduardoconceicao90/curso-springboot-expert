package com.eduardo.vendas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

    @GetMapping(value = "/hello/{nome}")
    @ResponseBody
    public String helloCliente(@PathVariable("nome") String nomeCliente){
        return String.format("Hello %s", nomeCliente);
    }
}
