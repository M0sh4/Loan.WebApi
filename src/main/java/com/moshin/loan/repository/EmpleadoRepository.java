package com.moshin.loan.repository;

import com.moshin.loan.entity.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
    
}
