package com.moshin.loan.controller;

import com.moshin.loan.entity.Usuario;
import com.moshin.loan.service.usuario.UsuarioService;

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
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario){
        Usuario resUsu = usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(resUsu);
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> getLogin(@RequestParam String cUsu, String cContra){
        Usuario resUsu = usuarioService.login(cUsu, cContra);
        return resUsu.getNId().toString().isEmpty()? ResponseEntity.notFound().build(): ResponseEntity.ok(resUsu);
    }
}
