package com.moshin.loan.controller;

import java.util.List;

import javax.validation.Valid;

import com.moshin.loan.entity.table.Pago;
import com.moshin.loan.service.error.GeneralResponse;
import com.moshin.loan.service.pago.PagoService;

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
@RequestMapping("/pago")
public class PagoController {
    
    @Autowired
    PagoService pagoService;
    @Autowired
    GeneralResponse generalResponse;

    @PostMapping
    public ResponseEntity<Object> savePago(@RequestBody @Valid Pago pago, BindingResult result){
        return result.hasErrors()? generalResponse.response(result): ResponseEntity.status(HttpStatus.CREATED).body(pagoService.save(pago));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Pago>> getPagoByPrestamo(@PathVariable("id") Long idPrestamo){
        List<Pago> resPago = pagoService.getPagoByPrestamo(idPrestamo);
        return resPago.isEmpty()? ResponseEntity.notFound().build(): ResponseEntity.ok(resPago);
    }

    @PostMapping("/delete")
    public ResponseEntity<Boolean> logicalDelete(@RequestParam Long id){
        Pago pago = pagoService.logicalDelete(id);
        return pago.isBActivo()? ResponseEntity.notFound().build(): ResponseEntity.ok(true);
    }
}
