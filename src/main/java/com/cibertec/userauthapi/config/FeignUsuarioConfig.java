package com.cibertec.userauthapi.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignUsuarioConfig {

    @Bean
    Logger.Level feignLoggerLevel(){ return Logger.Level.FULL;}
}
