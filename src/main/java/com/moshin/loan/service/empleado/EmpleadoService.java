package com.moshin.loan.service.empleado;

import java.util.List;
import java.util.Optional;

import com.moshin.loan.entity.Empleado;

public interface EmpleadoService {
    public Empleado save(Empleado empleado);

    public Empleado logicalDelete(String cDni);

    public List<Empleado> getEmpleado(String cRuc);

    public Optional<Empleado> getEmpleadoByDni(String cDni);
}
