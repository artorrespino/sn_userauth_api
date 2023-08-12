package com.cibertec.userauthapi.mappers;

import com.cibertec.userauthapi.dtos.RolCreateDTO;
import com.cibertec.userauthapi.dtos.RolDTO;
import com.cibertec.userauthapi.dtos.RolUpdateDTO;
import com.cibertec.userauthapi.model.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RolMapper {

    RolMapper INSTANCIA = Mappers.getMapper(RolMapper.class);

    RolDTO rolARolDTO(Rol rol);
    Rol rolDTOARol(RolDTO rolDTO);
    Rol rolCreateDTOARol(RolCreateDTO rolCreateDTO);
    Rol rolUpdateDTOARol(RolUpdateDTO rolUpdateDTO);

    List<RolDTO> listaRolAlistaRolDTO (List<Rol> listaRol);
}
