package com.moshin.loan.controller;

import java.util.List;

import javax.validation.Valid;

import com.moshin.loan.entity.table.ListaNegra;
import com.moshin.loan.service.error.GeneralResponse;
import com.moshin.loan.service.lista_negra.ListaNegraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/listaNegra")
public class ListaNegraController {

    @Autowired
    ListaNegraService listaNegraService;
    @Autowired
    GeneralResponse generalResponse;

    @PostMapping
    public ResponseEntity<Object> saveList(@RequestBody @Valid ListaNegra listaNegra, BindingResult result){
        return result.hasErrors()? generalResponse.response(result): ResponseEntity.status(HttpStatus.CREATED).body(listaNegraService.saveList(listaNegra));
    }
    
    @GetMapping("/byRuc/{id}")
    public ResponseEntity<List<ListaNegra>> getListByRuc(@PathVariable("id") String cRuc) {
        List<ListaNegra> resList = listaNegraService.getListByRuc(cRuc);
        return resList.isEmpty()? ResponseEntity.notFound().build(): ResponseEntity.ok(resList);
    }

    @PostMapping("/delete")
    public ResponseEntity<Boolean> logicalDelete(@RequestParam Long id){
        ListaNegra listaNegra = listaNegraService.logicalDelete(id);
        return listaNegra.isBActivo()? ResponseEntity.notFound().build(): ResponseEntity.ok(true);
    }
    
}
