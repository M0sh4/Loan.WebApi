package com.moshin.loan.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import com.moshin.loan.entity.Pago;
import com.moshin.loan.service.pago.PagoService;

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
@RequestMapping("/pago")
public class PagoController {
    
    @Autowired
    PagoService pagoService;

    @PostMapping
    public ResponseEntity<Pago> savePago(@RequestBody Pago pago){
        Pago resPago = pagoService.save(pago);
        return ResponseEntity.status(HttpStatus.CREATED).body(resPago);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Pago>> getPagoByPrestamo(@PathParam("id") Long idPrestamo){
        List<Pago> resPago = pagoService.getPagoByPrestamo(idPrestamo);
        return resPago.isEmpty()? ResponseEntity.notFound().build(): ResponseEntity.ok(resPago);
    }

    @PostMapping("/delete")
    public ResponseEntity<Boolean> logicalDelete(@RequestParam Long id){
        Pago pago = pagoService.logicalDelete(id);
        return pago.getCEstado().equals("0")? ResponseEntity.notFound().build(): ResponseEntity.ok(true);
    }
}
