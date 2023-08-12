package com.cibertec.userauthapi.feignUsuario;

import com.cibertec.userauthapi.config.FeignUsuarioConfig;
import com.cibertec.userauthapi.dtos.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="cliente-api", url="http://localhost:8081/api/clientes", configuration = FeignUsuarioConfig.class)
public interface ClienteFeignUsuario {

    @PostMapping()
    ClienteDTO registrarCliente(ClienteDTO clienteDTO);
}
