package com.moshin.loan.service.empresa;

import java.util.List;

import com.moshin.loan.entity.Empresa;
import com.moshin.loan.repository.EmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresaServiceImpl implements EmpresaService{

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    @Transactional
    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Empresa> getEmpresa() {
        return empresaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Empresa getEmpresaByRuc(String cRuc) {
        return empresaRepository.getById(cRuc);
    }
    
}