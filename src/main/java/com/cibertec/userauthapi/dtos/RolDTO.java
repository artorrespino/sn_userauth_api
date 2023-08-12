package com.cibertec.userauthapi.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class RolDTO {

    private Long idRol;
    private String rol;
}
