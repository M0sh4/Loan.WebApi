package com.moshin.loan.controller;

import javax.validation.Valid;

import com.moshin.loan.entity.JwtResponse;
import com.moshin.loan.entity.table.Usuario;
import com.moshin.loan.exceptions.ApiUnauthorized;
import com.moshin.loan.service.error.GeneralResponse;
import com.moshin.loan.service.usuario.UsuarioService;
import com.moshin.loan.validator.AuthValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    @Autowired
    private GeneralResponse generalResponse;

    @PostMapping("/save")
    public ResponseEntity<Object> saveUsuario(@RequestBody @Valid Usuario usuario, BindingResult result){
        return result.hasErrors()? generalResponse.response(result): ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
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
