package com.moshin.loan.service.documento;

import java.util.ArrayList;
import java.util.List;

import com.moshin.loan.entity.Documento;
import com.moshin.loan.repository.DocumentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DocumentoServiceImpl implements DocumentoService{

    @Autowired
    DocumentoRepository documentoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Documento> getDocumentoByCliente(String cDni, String cRuc) {
        ArrayList<Documento> listDocumento = new ArrayList<>();
        documentoRepository.findAll().forEach(documento ->{
            if(documento.getCliente().getCDNI().equals(cDni) && documento.getEmpresa().getCRUC().equals(cRuc)){
                listDocumento.add(documento);
            }
        });
        return listDocumento;
    }

    @Override
    @Transactional
    public Documento save(Documento documento) {
        return documentoRepository.save(documento);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        documentoRepository.deleteById(id);
        return !documentoRepository.existsById(id);
    }
    
}
