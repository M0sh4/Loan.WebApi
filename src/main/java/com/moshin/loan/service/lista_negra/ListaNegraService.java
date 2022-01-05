package com.moshin.loan.service.lista_negra;

import java.util.List;

import com.moshin.loan.entity.ListaNegra;

public interface ListaNegraService {
    public ListaNegra saveList(ListaNegra listaNegra);

    public List<ListaNegra> getListByRuc(String cRuc);

    public ListaNegra logicalDelete(Long id);
}
