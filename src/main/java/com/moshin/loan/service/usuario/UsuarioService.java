package com.moshin.loan.service.usuario;

import com.moshin.loan.entity.JwtResponse;
import com.moshin.loan.entity.table.Usuario;

public interface UsuarioService {
    
    public Usuario save(Usuario usuario);

    public JwtResponse login(String cUsu, String cContra);

}
