package com.moshin.loan.service.cliente;

import java.util.Optional;

import com.moshin.loan.entity.table.Cliente;


public interface ClienteService {
    
    public Iterable<Cliente> findAll();

    public Optional<Cliente> findById(String id);

    public Cliente save(Cliente cliente);
}
