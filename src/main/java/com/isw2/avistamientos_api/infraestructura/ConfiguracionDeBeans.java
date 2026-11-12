package com.isw2.avistamientos_api.infraestructura;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.isw2.avistamientos_api.casosdeuso.ActualizarAvistamiento;
import com.isw2.avistamientos_api.casosdeuso.AvistamientoGateway;
import com.isw2.avistamientos_api.casosdeuso.CrearAvistamiento;
import com.isw2.avistamientos_api.casosdeuso.EliminarAvistamiento;
import com.isw2.avistamientos_api.casosdeuso.ListarAvistamientos;
import com.isw2.avistamientos_api.casosdeuso.ResumenPorEspecie;
import com.isw2.avistamientos_api.casosdeuso.VerAvistamiento;
import com.isw2.avistamientos_api.entidades.Reloj;
import com.isw2.avistamientos_api.entidades.ValidadorDeAvistamiento;

@Configuration
public class ConfiguracionDeBeans {

    @Bean
    public ValidadorDeAvistamiento validadorDeAvistamiento(Reloj reloj) {
        return new ValidadorDeAvistamiento(reloj);
    }

    @Bean
    public CrearAvistamiento crearAvistamiento(AvistamientoGateway gateway, ValidadorDeAvistamiento validador) {
        return new CrearAvistamiento(gateway, validador);
    }

    @Bean
    public ListarAvistamientos listarAvistamientos(AvistamientoGateway gateway) {
        return new ListarAvistamientos(gateway);
    }

    @Bean
    public VerAvistamiento verAvistamiento(AvistamientoGateway gateway) {
        return new VerAvistamiento(gateway);
    }

    @Bean
    public ActualizarAvistamiento actualizarAvistamiento(AvistamientoGateway gateway, ValidadorDeAvistamiento validador) {
        return new ActualizarAvistamiento(gateway, validador);
    }

    @Bean
    public EliminarAvistamiento eliminarAvistamiento(AvistamientoGateway gateway) {
        return new EliminarAvistamiento(gateway);
    }

    @Bean
    public ResumenPorEspecie resumenPorEspecie(AvistamientoGateway gateway) {
        return new ResumenPorEspecie(gateway);
    }
}