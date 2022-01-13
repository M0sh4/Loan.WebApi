package com.moshin.loan.service.pago;

import java.util.List;

import com.moshin.loan.entity.table.Pago;

public interface PagoService {
    
    public Pago save(Pago pago);

    public List<Pago> getPagoByPrestamo(Long idPrestamo);

    public Pago logicalDelete(Long id);
}
