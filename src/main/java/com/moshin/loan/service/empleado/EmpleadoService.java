package com.moshin.loan.service.empleado;

import java.util.List;

import com.moshin.loan.entity.Empleado;

public interface EmpleadoService {
    public Empleado save(Empleado empleado);

    public Empleado logicalDelete(String cDni);

    public List<Empleado> getEmpleado(String cRuc);

    public Empleado getEmpleadoByDni(String cDni);
}
