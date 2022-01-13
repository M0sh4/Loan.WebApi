package com.moshin.loan.controller;

import com.moshin.loan.entity.JwtResponse;
import com.moshin.loan.entity.table.Usuario;
import com.moshin.loan.exceptions.ApiUnauthorized;
import com.moshin.loan.service.usuario.UsuarioService;
import com.moshin.loan.validator.AuthValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private AuthValidator validator;

    @PostMapping("/save")
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario){
        Usuario resUsu = usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(resUsu);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> getLogin(@RequestParam String cUsu, String cContra) throws ApiUnauthorized{
        validator.validate(cUsu, cContra);
        JwtResponse resUsu = usuarioService.login(cUsu, cContra);
        if(!resUsu.getUserId().toString().isEmpty()){
            return ResponseEntity.ok(resUsu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
