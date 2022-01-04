package com.moshin.loan.service.documento;

import java.util.List;

import com.moshin.loan.entity.Documento;

public interface DocumentoService {

    public Documento save(Documento documento);

    public List<Documento> getDocumentoByCliente(String cDni);

    public boolean delete(Long id);
}
