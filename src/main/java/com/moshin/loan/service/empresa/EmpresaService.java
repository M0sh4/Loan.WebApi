package com.moshin.loan.service.empresa;

import java.util.List;

import com.moshin.loan.entity.Empresa;

public interface EmpresaService {
    
    public Empresa save(Empresa empresa);

    public List<Empresa> getEmpresa();

    public Empresa getEmpresaByRuc(String cRuc);


}