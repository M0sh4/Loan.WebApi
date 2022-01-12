package com.moshin.loan.controller;

import java.util.List;


import com.moshin.loan.entity.Prestamo;
import com.moshin.loan.service.prestamo.PrestamoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prestamo")
public class PrestamoController {
    
    @Autowired
    PrestamoService prestamoService;

    @PostMapping
    public ResponseEntity<Prestamo> savePrestamo(@RequestBody Prestamo prestamo){
        Prestamo resPres = prestamoService.save(prestamo);
        return ResponseEntity.status(HttpStatus.CREATED).body(resPres);
    }

    @GetMapping("/byRuc/{id}")
    public ResponseEntity<List<Prestamo>> getPrestamoByRuc(@PathVariable("id") String cRuc){
        List<Prestamo> listRes = prestamoService.getPrestamoByRuc(cRuc);
        return listRes.isEmpty()? ResponseEntity.notFound().build(): ResponseEntity.ok(listRes);
    }

    @GetMapping("/byDni/{id}")
    public ResponseEntity<List<Prestamo>> getPrestamoByDni(@PathVariable("id") String cDni){
        List<Prestamo> listRes = prestamoService.getPrestamoByDni(cDni);
        return listRes.isEmpty()? ResponseEntity.notFound().build(): ResponseEntity.ok(listRes);
    }

    @PostMapping("/delete")
    public ResponseEntity<Boolean> logicalDelete(@RequestParam Long id){
        Prestamo resPres = prestamoService.logicalDelete(id);
        return resPres.getCEstado().equals("0")? ResponseEntity.ok(true): ResponseEntity.notFound().build();
    }
}
