package com.moshin.loan.repository;

import com.moshin.loan.entity.table.TipoPrestamo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPrestamoRepository extends JpaRepository<TipoPrestamo, Long> {
    
}
