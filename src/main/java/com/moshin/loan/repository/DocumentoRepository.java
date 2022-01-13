package com.moshin.loan.repository;

import com.moshin.loan.entity.table.Documento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long>{
    
}
