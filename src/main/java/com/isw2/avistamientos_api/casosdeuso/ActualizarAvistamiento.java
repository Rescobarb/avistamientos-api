package com.isw2.avistamientos_api.casosdeuso;

import java.util.Optional;

import com.isw2.avistamientos_api.entidades.Avistamiento;
import com.isw2.avistamientos_api.entidades.ValidadorDeAvistamiento;

public class ActualizarAvistamiento {

    private final AvistamientoGateway gateway;
    private final ValidadorDeAvistamiento validador;

    public ActualizarAvistamiento(AvistamientoGateway gateway, ValidadorDeAvistamiento validador) {
        this.gateway = gateway;
        this.validador = validador;
    }

    public Optional<Avistamiento> ejecutar(Long id, Avistamiento datos) {
        validador.validar(datos);
        return gateway.buscarPorId(id).map(existente -> {
            existente.setEspecie(datos.getEspecie());
            existente.setLugar(datos.getLugar());
            existente.setFecha(datos.getFecha());
            existente.setObservador(datos.getObservador());
            return gateway.guardar(existente);
        });
    }
}