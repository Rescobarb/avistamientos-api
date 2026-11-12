package com.isw2.avistamientos_api.casosdeuso;

import java.util.Optional;

import com.isw2.avistamientos_api.entidades.Avistamiento;

public class VerAvistamiento {

    private final AvistamientoGateway gateway;

    public VerAvistamiento(AvistamientoGateway gateway) {
        this.gateway = gateway;
    }

    public Optional<Avistamiento> ejecutar(Long id) {
        return gateway.buscarPorId(id);
    }
}