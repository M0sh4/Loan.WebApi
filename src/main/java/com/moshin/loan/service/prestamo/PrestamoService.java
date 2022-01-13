package com.moshin.loan.service.prestamo;

import java.util.List;

import com.moshin.loan.entity.table.Prestamo;

public interface PrestamoService {
    
    public Prestamo save(Prestamo prestamo);

    public List<Prestamo> getPrestamoByRuc(String cRuc);

    public List<Prestamo> getPrestamoByDni(String cDni);

    public Prestamo logicalDelete(Long id);
}
