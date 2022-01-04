package com.moshin.loan.service.empleado;

import java.util.List;

import com.moshin.loan.entity.Empleado;

public interface EmpleadoService {
    public Empleado save(Empleado empleado);

    public Empleado logicalDelete(String cDni);

    public List<Empleado> readEmpleado(String cRuc);

    public Empleado readEmpleadoByDni(String cDni);
}
