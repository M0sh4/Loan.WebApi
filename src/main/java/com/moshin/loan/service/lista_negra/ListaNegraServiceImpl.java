package com.moshin.loan.service.lista_negra;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.moshin.loan.entity.table.ListaNegra;
import com.moshin.loan.repository.ListaNegraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ListaNegraServiceImpl implements ListaNegraService{

    @Autowired
    ListaNegraRepository listaNegraRepository;

    @Override
    @Transactional
    public ListaNegra saveList(ListaNegra listaNegra) {
        Date date = new Date();
        listaNegra.setBActivo(true);
        listaNegra.setDtFechaReg(date);
        return listaNegraRepository.save(listaNegra);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ListaNegra> getListByRuc(String cRuc) {
        List<ListaNegra> resList = new ArrayList<>();
        listaNegraRepository.findAll().forEach(listaNegra->{
            if(listaNegra.getEmpresa().getCRUC().equals(cRuc)){
                resList.add(listaNegra);
            }
        });
        return resList;
    }

    @Override
    @Transactional
    public ListaNegra logicalDelete(Long id) {
        ListaNegra listaNegra = listaNegraRepository.getById(id);
        listaNegra.setBActivo(false);
        return listaNegraRepository.save(listaNegra);
    }
    
}
