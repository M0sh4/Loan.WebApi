package com.moshin.loan.service.recomendado;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.moshin.loan.entity.table.Recomendado;
import com.moshin.loan.repository.RecomendadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReomendadoServiceImpl implements RecomendadoService {

    @Autowired
    RecomendadoRepository recomendadoRepository;

    @Override
    @Transactional
    public Recomendado save(Recomendado recomendado) {
        Date date = new Date();
        recomendado.setDtFechaReg(date);
        recomendado.setBActivo(true);
        return recomendadoRepository.save(recomendado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Recomendado> getRecomendadoByRuc(String cRuc) {
        List<Recomendado> listRec = new ArrayList<>();
        recomendadoRepository.findAll().forEach(recomendado->{
            if(recomendado.getEmpresa().getCRUC().equals(cRuc)){
                listRec.add(recomendado);
            }
        });
        return listRec;
    }

    @Override
    @Transactional
    public Recomendado logicalDelete(Long id) {
        Recomendado recomendado = recomendadoRepository.getById(id);
        recomendado.setBActivo(false);
        return recomendadoRepository.save(recomendado);
    }
    
}
