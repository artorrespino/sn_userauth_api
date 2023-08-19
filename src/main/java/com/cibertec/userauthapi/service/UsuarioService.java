package com.cibertec.userauthapi.service;

import com.cibertec.userauthapi.dtos.UsuarioCreateDTO;
import com.cibertec.userauthapi.dtos.UsuarioDTO;
import com.cibertec.userauthapi.dtos.UsuarioUpdateDTO;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDTO> listarUsuarios();
    UsuarioDTO obtenerUsuarioPorID(long id);
    UsuarioDTO registrarUsuario(UsuarioCreateDTO usuarioCreateDTO);
    UsuarioDTO actualizarUsuario(UsuarioUpdateDTO usuarioUpdateDTO);
    UsuarioDTO eliminarUsuario(long id);

    UsuarioDTO login (String email, String password);
}
