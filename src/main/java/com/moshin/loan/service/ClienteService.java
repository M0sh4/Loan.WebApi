package com.moshin.loan.service;

import java.util.Optional;

import com.moshin.loan.entity.Cliente;


public interface ClienteService {
    
    public Iterable<Cliente> findAll();

    public Optional<Cliente> findById(String id);

    public Cliente save(Cliente cliente);
}
