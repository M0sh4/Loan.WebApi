package com.moshin.loan.service.pago;
import java.util.ArrayList;
import java.util.List;

import com.moshin.loan.entity.table.Pago;
import com.moshin.loan.repository.PagoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PagoServiceImpl implements PagoService{

    @Autowired
    PagoRepository pagoRepository;

    @Override
    @Transactional
    public Pago save(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pago> getPagoByPrestamo(Long idPrestamo) {
        List<Pago> listPago = new ArrayList<>();
        pagoRepository.findAll().forEach(pago->{
            if(pago.getPrestamo().getNId().equals(idPrestamo)){
                listPago.add(pago);
            }
        });
        return listPago;
    }

    @Override
    @Transactional
    public Pago logicalDelete(Long id) {
        Pago pago = pagoRepository.getById(id);
        pago.setCEstado("0");
        return pagoRepository.save(pago);
    }
    
}
