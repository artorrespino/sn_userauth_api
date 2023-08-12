package com.cibertec.userauthapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tb_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombres", length = 100, nullable = false)
    private String nombres;

    @Column(name = "ap_paterno", length = 50, nullable = false)
    private String apPaterno;

    @Column(name = "ap_materno", length = 50, nullable = false)
    private String apMaterno;

    @Column(name = "celular", length = 20, nullable = false)
    private String celular;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "contrasenia", length = 50, nullable = false)
    private String contrasenia;

    @Column(name = "intentos_login")
    private Integer intentosLogin;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;
}
