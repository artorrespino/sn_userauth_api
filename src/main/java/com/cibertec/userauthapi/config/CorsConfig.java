package com.cibertec.userauthapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // Especifica el origen permitido (URL del frontend)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
                .allowedHeaders("Content-Type", "Authorization") // Encabezados HTTP permitidos
                .allowCredentials(true) // Permite enviar cookies y encabezados de autenticación
                .maxAge(3600); // Tiempo de almacenamiento en caché para respuestas preflight (en segundos)
    }
}
