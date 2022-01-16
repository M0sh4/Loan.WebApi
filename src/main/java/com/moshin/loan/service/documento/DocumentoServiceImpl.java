package com.moshin.loan.service.documento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.moshin.loan.entity.table.Documento;
import com.moshin.loan.repository.DocumentoRepository;
import com.moshin.loan.util.DateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DocumentoServiceImpl implements DocumentoService{

    @Autowired
    DocumentoRepository documentoRepository;
    @Autowired
    DateUtils dateUtils;

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
        Date dateNow = new Date();
        documento.setDtFechaReg(dateNow);
        documento.setBActivo(true);
        return documentoRepository.save(documento);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        documentoRepository.deleteById(id);
        return !documentoRepository.existsById(id);
    }
    
}
