package com.cibertec.userauthapi.service;

import com.cibertec.userauthapi.dtos.*;
import com.cibertec.userauthapi.feignUsuario.ClienteFeignUsuario;
import com.cibertec.userauthapi.mappers.UsuarioMapper;
import com.cibertec.userauthapi.model.Usuario;
import com.cibertec.userauthapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioServiceImplo implements UsuarioService {

    @Value("${constantes.ESTADO_ACTIVO}")
    private String estadoActivo;

    @Value("${constantes.ESTADO_INACTIVO}")
    private String estadoEliminado;

    @Value("${constantes.ROL_ADMINISTRADOR}")
    private String rolAdmin;


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteFeignUsuario clienteFeignUsuario;

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return UsuarioMapper.INSTANCIA.listaUsuarioAListaUsuarioDTO(usuarioRepository.findAll());
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorID(long id) {
        return usuarioRepository.findById(id)
                .map(UsuarioMapper.INSTANCIA::usuarioAUsuarioDTO)
                .orElse(null);
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioCreateDTO usuarioCreateDTO) {
        Usuario usuario = UsuarioMapper.INSTANCIA.usuarioCreateDTOAUsuario(usuarioCreateDTO);
        usuario.setEstado(estadoActivo);// Asignar el estado activo al usuario antes de guardarlo
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        // if cliente isn't ADMIN (1)
        if(usuarioGuardado.getRol().getIdRol() != 1){
            // Registrar el cliente
            ClienteDTO clienteDTO = usuarioCreateDTO.getCliente();
            clienteDTO.setIdUsuario(usuarioGuardado.getIdUsuario());
            clienteFeignUsuario.registrarCliente(clienteDTO);

        }

        return UsuarioMapper.INSTANCIA.usuarioAUsuarioDTO((usuarioGuardado));
    }

    @Override
    public UsuarioDTO actualizarUsuario(UsuarioUpdateDTO usuarioUpdateDTO) {
        Usuario usuario = UsuarioMapper.INSTANCIA.usuarioUpdateDTOAUsuario(usuarioUpdateDTO);
        Usuario respuestaEntity = usuarioRepository.save(usuario);
        return UsuarioMapper.INSTANCIA.usuarioAUsuarioDTO(respuestaEntity);
    }

    @Override
    public UsuarioDTO eliminarUsuario(long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setEstado(estadoEliminado);
            usuarioRepository.save(usuario);
            UsuarioDTO usuarioDTO = UsuarioMapper.INSTANCIA.usuarioAUsuarioDTO(usuario);
            return usuarioDTO;
        } else {
            throw new NoSuchElementException("No se encontró el usuario con ID = " + id);
        }
    }

    @Override
    public UsuarioDTO login(String email, String password) {
        Usuario usuario = usuarioRepository.getUsuarioByEmail(email);

        if (usuario != null && password.equals(usuario.getContrasenia())){
            UsuarioDTO usuarioLogin = UsuarioMapper.INSTANCIA.usuarioAUsuarioDTO(usuario);
            return usuarioLogin;

        } else {
            return null;
        }

    }
}
