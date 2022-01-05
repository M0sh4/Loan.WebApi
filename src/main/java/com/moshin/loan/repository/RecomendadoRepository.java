package com.moshin.loan.repository;

import com.moshin.loan.entity.Recomendado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecomendadoRepository extends JpaRepository<Recomendado, Long> {
    
}
