package com.cibertec.userauthapi.mappers;

import com.cibertec.userauthapi.dtos.UsuarioCreateDTO;
import com.cibertec.userauthapi.dtos.UsuarioDTO;
import com.cibertec.userauthapi.dtos.UsuarioUpdateDTO;
import com.cibertec.userauthapi.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCIA = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO usuarioAUsuarioDTO(Usuario usuario);
    Usuario usuarioDTOAUsuario(UsuarioDTO usuarioDTO);
    Usuario usuarioCreateDTOAUsuario(UsuarioCreateDTO usuarioCreateDTO);
    Usuario usuarioUpdateDTOAUsuario(UsuarioUpdateDTO usuarioUpdateDTO);

    List<UsuarioDTO> listaUsuarioAListaUsuarioDTO (List<Usuario> listaUsuario);
}
