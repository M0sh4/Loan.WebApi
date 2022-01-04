package com.moshin.loan.service.empleado;


import java.util.ArrayList;
import java.util.List;

import com.moshin.loan.entity.Empleado;
import com.moshin.loan.repository.EmpleadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    @Transactional
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    @Transactional
    public Empleado logicalDelete(String cDni) {
        Empleado empleado = empleadoRepository.getById(cDni);
        empleado.setCEstado("0");
        return empleadoRepository.save(empleado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> readEmpleado(String cRuc) {
        List<Empleado> listEmp = new ArrayList<>();
        empleadoRepository.findAll().forEach(empleado ->{
            if(empleado.getEmpresa().getCRUC().equals(cRuc)){
                listEmp.add(empleado);
            }
        });
        return listEmp;
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado readEmpleadoByDni(String cDni) {
        return empleadoRepository.getById(cDni);
    }
    
}
