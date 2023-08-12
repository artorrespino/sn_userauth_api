package com.cibertec.userauthapi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClienteDTO {

    private Long idCliente;
    private Date fecNacimiento;
    private String numDocIdentidad;
    private Long idUsuario; // dato de microservicio externo
    private TipoDocIdentidadDTO tipoDocIdentidad;
}
