package com.cibertec.userauthapi.controller;

import com.cibertec.userauthapi.dtos.UsuarioCreateDTO;
import com.cibertec.userauthapi.dtos.UsuarioDTO;
import com.cibertec.userauthapi.dtos.UsuarioUpdateDTO;
import com.cibertec.userauthapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{usuarioId}")
    public UsuarioDTO obtenerUsuarioPorId(@PathVariable long usuarioId) {
        return usuarioService.obtenerUsuarioPorID(usuarioId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO registrarUsuario(@RequestBody UsuarioCreateDTO usuarioCreateDTO) {
        return usuarioService.registrarUsuario(usuarioCreateDTO);
    }

    @PutMapping
    public UsuarioDTO actualizarUsuario(@RequestBody UsuarioUpdateDTO usuarioUpdateDTO) {
        return usuarioService.actualizarUsuario(usuarioUpdateDTO);
    }

    @DeleteMapping("/{usuarioId}")
    public UsuarioDTO eliminarUsuario(@PathVariable long usuarioId) {
        return usuarioService.eliminarUsuario(usuarioId);
    }
}
