package com.moshin.loan.controller;

import java.util.Optional;

import com.moshin.loan.entity.Cliente;
import com.moshin.loan.service.cliente.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
        Cliente clienteRes = clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> readCliente(@PathVariable String id){
        Optional<Cliente> oCliente = clienteService.findById(id);
        return oCliente.isPresent()? ResponseEntity.ok(oCliente): ResponseEntity.notFound().build();
    }
}
