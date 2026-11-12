package com.isw2.avistamientos_api.infraestructura;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.isw2.avistamientos_api.entidades.Reloj;
import com.isw2.avistamientos_api.entidades.ValidadorDeAvistamiento;

@Configuration
public class ConfiguracionDeBeans {

    @Bean
    public ValidadorDeAvistamiento validadorDeAvistamiento(Reloj reloj) {
        return new ValidadorDeAvistamiento(reloj);
    }
}