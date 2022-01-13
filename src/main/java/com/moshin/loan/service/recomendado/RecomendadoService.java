package com.moshin.loan.service.recomendado;

import java.util.List;

import com.moshin.loan.entity.table.Recomendado;

public interface RecomendadoService {
    
    public Recomendado save(Recomendado recomendado);

    public List<Recomendado> getRecomendadoByRuc(String cRuc);

    public Recomendado logicalDelete(Long id);
}
