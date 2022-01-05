package com.moshin.loan.service.usuario;

import com.moshin.loan.entity.Usuario;

public interface UsuarioService {
    
    public Usuario save(Usuario usuario);

    public Usuario login(String cUsu, String cContra);

}
