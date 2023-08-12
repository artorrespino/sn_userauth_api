package com.cibertec.userauthapi.service;

import com.cibertec.userauthapi.dtos.RolCreateDTO;
import com.cibertec.userauthapi.dtos.RolDTO;
import com.cibertec.userauthapi.dtos.RolUpdateDTO;
import com.cibertec.userauthapi.mappers.RolMapper;
import com.cibertec.userauthapi.model.Rol;
import com.cibertec.userauthapi.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService{

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<RolDTO> listarRoles() {
        return RolMapper.INSTANCIA.listaRolAlistaRolDTO(rolRepository.findAll());
    }

    @Override
    public RolDTO obtenerRolPorID(long id) {
        return rolRepository.findById(id)
                .map(RolMapper.INSTANCIA::rolARolDTO)
                .orElse(null);

    }

    @Override
    public RolDTO registrarRol(RolCreateDTO rolCreateDTO) {
        Rol rol = RolMapper.INSTANCIA.rolCreateDTOARol(rolCreateDTO);
        Rol respuestaEntity = rolRepository.save(rol);
        return RolMapper.INSTANCIA.rolARolDTO(respuestaEntity);
    }

    @Override
    public RolDTO actualizarRol(RolUpdateDTO rolUpdateDTO) {
        Rol rol = RolMapper.INSTANCIA.rolUpdateDTOARol(rolUpdateDTO);
        Rol respuestaEntity = rolRepository.save(rol);
        return RolMapper.INSTANCIA.rolARolDTO(respuestaEntity);
    }

    @Override
    public String eliminarRol(long id) {
        Optional<Rol> rolOptional = rolRepository.findById(id);
        rolOptional.ifPresentOrElse(
                rol -> rolRepository.deleteById(id),
                () -> {
                    throw new NoSuchElementException("No se encontró el rol con id = " + id);
                }
        );
        return "Registro de rol eliminado";
    }
}
