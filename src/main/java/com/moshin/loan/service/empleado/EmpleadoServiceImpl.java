package com.moshin.loan.service.empleado;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.moshin.loan.entity.table.Empleado;
import com.moshin.loan.repository.EmpleadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    @Transactional
    public Empleado save(Empleado empleado) {
        Date date = new Date();
        empleado.setDtFechaReg(date);
        empleado.setBActivo(true);
        return empleadoRepository.save(empleado);
    }

    @Override
    @Transactional
    public Empleado logicalDelete(String cDni) {
        Empleado empleado = empleadoRepository.getById(cDni);
        empleado.setBActivo(false);
        return empleadoRepository.save(empleado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> getEmpleado(String cRuc) {
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
    public Optional<Empleado> getEmpleadoByDni(String cDni) {
        return empleadoRepository.findById(cDni);
    }
    
}
