package com.moshin.loan.service.empresa;

import java.util.List;
import java.util.Optional;

import com.moshin.loan.entity.table.Empresa;

public interface EmpresaService {
    
    public Empresa save(Empresa empresa);

    public List<Empresa> getEmpresa();

    public Optional<Empresa> getEmpresaByRuc(String cRuc);


}