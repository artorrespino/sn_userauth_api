package com.cibertec.userauthapi.dtos;

import com.cibertec.userauthapi.model.Rol;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private Long idUsuario;
    private String nombres;
    private String apPaterno;
    private String apMaterno;
    private String celular;
    private String email;
    private String contrasenia;
    private Integer intentosLogin;
    private String estado;
    private Rol rol;
}
