package com.moshin.loan.service.prestamo;

import java.util.ArrayList;
import java.util.List;

import com.moshin.loan.entity.table.Prestamo;
import com.moshin.loan.repository.PrestamoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrestamoServiceImpl implements PrestamoService{

    @Autowired
    PrestamoRepository prestamoRepository;

    @Override
    @Transactional
    public Prestamo save(Prestamo prestamo) {
        prestamo.setBActivo(true);
        return prestamoRepository.save(prestamo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Prestamo> getPrestamoByRuc(String cRuc) {
        List<Prestamo> listPrestamo = new ArrayList<>();
        prestamoRepository.findAll().forEach(prestamo->{
            if(prestamo.getEmpresa().getCRUC().equals(cRuc)){
                listPrestamo.add(prestamo);
            }
        });
        return listPrestamo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Prestamo> getPrestamoByDni(String cDni) {
        List<Prestamo> listPrestamo = new ArrayList<>();
        prestamoRepository.findAll().forEach(prestamo->{
            if(prestamo.getCliente().getCDNI().equals(cDni)){
                listPrestamo.add(prestamo);
            }
        });
        return listPrestamo;
    }

    @Override
    @Transactional
    public Prestamo logicalDelete(Long id) {
        Prestamo prestamo = prestamoRepository.getById(id);
        prestamo.setBActivo(false);
        return prestamoRepository.save(prestamo);
    }
    
}
