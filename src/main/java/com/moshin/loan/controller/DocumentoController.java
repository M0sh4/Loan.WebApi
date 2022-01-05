package com.moshin.loan.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import com.moshin.loan.entity.Documento;
import com.moshin.loan.service.documento.DocumentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/documento")
public class DocumentoController {
    @Autowired
    DocumentoService documentoService;

    @PostMapping
    public ResponseEntity<Documento> saveDoc(@RequestBody Documento documento){
        Documento docRes = documentoService.save(documento);
        return ResponseEntity.status(HttpStatus.CREATED).body(docRes);
    }

    @GetMapping(name = "/{id}")
    public ResponseEntity<List<Documento>> readDocByCliente(@PathParam("id") String cDni){
        List<Documento> listDoc = documentoService.getDocumentoByCliente(cDni);
        return listDoc.isEmpty()? ResponseEntity.notFound().build(): ResponseEntity.ok(listDoc);
    }

    @PostMapping
    public ResponseEntity<Boolean> deleteDocumento(@RequestParam Long id){
        boolean res = documentoService.delete(id);
        return res? ResponseEntity.ok(res): ResponseEntity.notFound().build();
    }
}
