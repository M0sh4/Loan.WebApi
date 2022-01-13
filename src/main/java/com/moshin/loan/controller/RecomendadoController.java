package com.moshin.loan.controller;

import java.util.List;

import com.moshin.loan.entity.table.Recomendado;
import com.moshin.loan.service.recomendado.RecomendadoService;

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
@RequestMapping("/recomendado")
public class RecomendadoController {
    
    @Autowired
    RecomendadoService recomendadoService;

    @PostMapping
    public ResponseEntity<Recomendado> saveRecomendado(@RequestBody Recomendado recomendado){
        Recomendado resRec = recomendadoService.save(recomendado);
        return ResponseEntity.status(HttpStatus.CREATED).body(resRec);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Recomendado>> getRecomendadoByRuc(@PathVariable("id") String cRuc){
        List<Recomendado> listRec = recomendadoService.getRecomendadoByRuc(cRuc);
        return listRec.isEmpty()? ResponseEntity.notFound().build(): ResponseEntity.ok(listRec);
    }

    @PostMapping("/delete")
    public ResponseEntity<Boolean> logicalDelete(@RequestParam Long id){
        Recomendado recomendado = recomendadoService.logicalDelete(id);
        return !recomendado.getCEstado().equals("0")? ResponseEntity.notFound().build(): ResponseEntity.ok(true);
    }
}
