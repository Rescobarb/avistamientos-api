package com.isw2.avistamientos_api.casosdeuso;

import java.util.Map;
import java.util.stream.Collectors;

import com.isw2.avistamientos_api.entidades.Avistamiento;

public class ResumenPorEspecie {

    private final AvistamientoGateway gateway;

    public ResumenPorEspecie(AvistamientoGateway gateway) {
        this.gateway = gateway;
    }

    public Map<String, Long> ejecutar() {
        return gateway.listar().stream()
                .collect(Collectors.groupingBy(Avistamiento::getEspecie, Collectors.counting()));
    }
}