package com.moshin.loan.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.moshin.loan.entity.table.Documento;
import com.moshin.loan.service.documento.DocumentoService;
import com.moshin.loan.service.error.GeneralResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/documento")
public class DocumentoController {
    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private GeneralResponse generalResponse;

    @PostMapping("/save")
    public ResponseEntity<Object> saveDoc(@RequestBody @Valid Documento documento, BindingResult result){
        return result.hasErrors()? generalResponse.response(result): ResponseEntity.status(HttpStatus.CREATED).body(documentoService.save(documento));
    }

    @GetMapping
    public ResponseEntity<List<Documento>> readDocByCliente(@RequestParam String dni, @RequestParam String ruc){
        List<Documento> listDoc = documentoService.getDocumentoByCliente(dni, ruc);
        return listDoc.isEmpty()? ResponseEntity.notFound().build(): ResponseEntity.ok(listDoc);
    }

    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteDoc(@RequestParam Long id){
        boolean res = documentoService.delete(id);
        return res? ResponseEntity.ok(res): ResponseEntity.notFound().build();
    }
}
