package com.moshin.loan.controller;

import java.util.List;

import javax.validation.Valid;

import com.moshin.loan.entity.table.TipoPrestamo;
import com.moshin.loan.service.error.GeneralResponse;
import com.moshin.loan.service.tipo_prestamo.TipoPrestamoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipoPrestamo")
public class TipoPrestamoController {
    
    @Autowired
    TipoPrestamoService tipoPrestamoService;
    @Autowired
    GeneralResponse generalResponse;

    @PostMapping
    public ResponseEntity<Object> saveTipoPrestamo(@RequestBody @Valid TipoPrestamo tipoPrestamo, BindingResult result){
        return result.hasErrors()? generalResponse.response(result): ResponseEntity.status(HttpStatus.CREATED).body(tipoPrestamoService.save(tipoPrestamo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TipoPrestamo>> getTipoPrestamoByRuc(@PathVariable("id") String cRuc){
        List<TipoPrestamo> listTipo = tipoPrestamoService.getTipoByRuc(cRuc);
        return listTipo.isEmpty()? ResponseEntity.notFound().build(): ResponseEntity.ok(listTipo);
    }

    @PostMapping("/delete")
    public ResponseEntity<Boolean> logicalDelete(@RequestParam Long id){
        TipoPrestamo resTipo =  tipoPrestamoService.logicalDelete(id);
        return !resTipo.isBActivo()? ResponseEntity.ok(true): ResponseEntity.notFound().build();
    }
}
