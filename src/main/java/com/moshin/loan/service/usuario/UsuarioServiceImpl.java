package com.moshin.loan.service.usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.moshin.loan.entity.JwtResponse;
import com.moshin.loan.entity.table.Usuario;
import com.moshin.loan.repository.UsuarioRepository;
import com.moshin.loan.security.JwtIO;
import com.moshin.loan.util.DateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    private JwtIO jwtIO;
    @Autowired
    private DateUtils dateUtils;
    @Value("${moshin.jwt.token.expires-in}")
    private int EXPIRES_IN;

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public JwtResponse login(String cUsu, String cContra) {
        List<Usuario> listUsu = new ArrayList<>();
        usuarioRepository.findAll().forEach(usuario->{
            if(usuario.getCContrasena().equals(cContra)&& usuario.getCUsuario().equals(cUsu)){
                listUsu.add(0,usuario);
                return;
            }
        });
        Map<String, String> usuRes = new HashMap<>();
        usuRes.put("name", listUsu.get(0).getCUsuario());
        usuRes.put("tipoUser", listUsu.get(0).getCTipoUsuario());
        return JwtResponse.builder().tokenType("bearer").accessToken(jwtIO.generateToken(usuRes)).issuedAt(dateUtils.getDateMillis()+"")
                .userId(listUsu.get(0).getNId()).expiresIn(EXPIRES_IN).build();
    }
    
}
