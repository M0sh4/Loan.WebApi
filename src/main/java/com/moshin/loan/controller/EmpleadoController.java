package com.moshin.loan.controller;

import java.util.List;
import java.util.Optional;

import com.moshin.loan.entity.table.Empleado;
import com.moshin.loan.service.empleado.EmpleadoService;

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
@RequestMapping("/empleado")
public class EmpleadoController {
    
    @Autowired
    EmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<Empleado> saveEmpleado(@RequestBody Empleado empleado){
        Empleado resEmp = empleadoService.save(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(resEmp);
    }

    @PostMapping("/delete")
    public ResponseEntity<Boolean> postMethodName(@RequestParam String cDni) {
        boolean res = empleadoService.logicalDelete(cDni).getCEstado().equals("0");
        return ResponseEntity.ok(res);
    }
    
    @GetMapping("/byRuc/{id}")
    public ResponseEntity<List<Empleado>> getEmpleadoByRuc(@PathVariable("id") String cRuc){
        List<Empleado> listEmp = empleadoService.getEmpleado(cRuc);
        return listEmp.isEmpty()? ResponseEntity.notFound().build(): ResponseEntity.ok(listEmp);
    }

    @GetMapping("/byDni/{id}")
    public ResponseEntity<Optional<Empleado>> getEmpleadoByDni(@PathVariable("id") String cDni){
        Optional<Empleado> emp = empleadoService.getEmpleadoByDni(cDni);
        return !emp.isPresent()? ResponseEntity.notFound().build(): ResponseEntity.ok(emp);
    }
}
