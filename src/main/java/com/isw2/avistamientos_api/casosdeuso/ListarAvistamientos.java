package com.isw2.avistamientos_api.casosdeuso;

import java.util.List;

import com.isw2.avistamientos_api.entidades.Avistamiento;

public class ListarAvistamientos {

    private final AvistamientoGateway gateway;

    public ListarAvistamientos(AvistamientoGateway gateway) {
        this.gateway = gateway;
    }

    public List<Avistamiento> ejecutar() {
        return gateway.listar();
    }
}