package com.moshin.loan.service.cliente;
import java.util.Date;
import java.util.Optional;

import com.moshin.loan.entity.table.Cliente;
import com.moshin.loan.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> findById(String id) {
        return clienteRepository.findById(id);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        Date date = new Date();
        cliente.setDtFechaReg(date);
        return clienteRepository.save(cliente);
    }
    
}
