package com.moshin.loan.service.usuario;

import java.util.ArrayList;
import java.util.List;

import com.moshin.loan.entity.Usuario;
import com.moshin.loan.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario login(String cUsu, String cContra) {
        List<Usuario> listUsu = new ArrayList<>();
        usuarioRepository.findAll().forEach(usuario->{
            if(usuario.getCContrasena().equals(cContra)&& usuario.getCUsuario().equals(cUsu)){
                listUsu.add(0,usuario);
            }
        });
        return listUsu.get(0);
    }
    
}
