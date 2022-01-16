package com.moshin.loan.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import com.moshin.loan.entity.table.Cliente;
import com.moshin.loan.service.cliente.ClienteService;
import com.moshin.loan.service.error.GeneralResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    @Autowired
    private GeneralResponse generalResponse;

    @PostMapping
    public ResponseEntity<Object> createCliente(@RequestBody @Valid Cliente cliente, BindingResult result){
        return result.hasErrors()? generalResponse.response(result): ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> readCliente(@PathVariable String id){
        Optional<Cliente> oCliente = clienteService.findById(id);
        return oCliente.isPresent()? ResponseEntity.ok(oCliente): ResponseEntity.notFound().build();
    }
}
