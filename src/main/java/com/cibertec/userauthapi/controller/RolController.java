package com.cibertec.userauthapi.controller;

import com.cibertec.userauthapi.dtos.RolCreateDTO;
import com.cibertec.userauthapi.dtos.RolDTO;
import com.cibertec.userauthapi.dtos.RolUpdateDTO;
import com.cibertec.userauthapi.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:4200")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<RolDTO>> listarRoles() {
        return ResponseEntity.ok(rolService.listarRoles());
    }

    @GetMapping("/{rolId}")
    public ResponseEntity<RolDTO> obtenerRolPorId(@PathVariable("rolId") long rolId) {
        return ResponseEntity.ok(rolService.obtenerRolPorID(rolId));
    }

    @PostMapping
    public ResponseEntity<RolDTO> registrarRol(@RequestBody RolCreateDTO rolCreateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rolService.registrarRol(rolCreateDTO));
    }

    @PutMapping
    public ResponseEntity<RolDTO> actualizarRol(@RequestBody RolUpdateDTO rolUpdateDTO) {
        return ResponseEntity.ok(rolService.actualizarRol(rolUpdateDTO));
    }

    @DeleteMapping("/{rolId}")
    public ResponseEntity<Void> eliminarRol(@PathVariable("rolId") long rolId) {
        rolService.eliminarRol(rolId);
        return ResponseEntity.noContent().build();
    }
}
