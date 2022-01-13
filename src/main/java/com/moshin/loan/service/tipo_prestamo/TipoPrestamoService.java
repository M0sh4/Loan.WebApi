package com.moshin.loan.service.tipo_prestamo;

import java.util.List;

import com.moshin.loan.entity.table.TipoPrestamo;

public interface TipoPrestamoService {

    public TipoPrestamo save(TipoPrestamo tipoPrestamo);

    public List<TipoPrestamo> getTipoByRuc(String cRuc);

    public TipoPrestamo logicalDelete(Long id);
    
}
