package com.moshin.loan.repository;

import com.moshin.loan.entity.table.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, String>{
    
}
