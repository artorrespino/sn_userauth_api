package com.cibertec.userauthapi.service;

import com.cibertec.userauthapi.dtos.RolCreateDTO;
import com.cibertec.userauthapi.dtos.RolDTO;
import com.cibertec.userauthapi.dtos.RolUpdateDTO;

import java.util.List;

public interface RolService {

    List<RolDTO> listarRoles();
    RolDTO obtenerRolPorID(long id);
    RolDTO registrarRol(RolCreateDTO rolCreateDTO);
    RolDTO actualizarRol(RolUpdateDTO rolUpdateDTO);
    String eliminarRol(long id);
}
