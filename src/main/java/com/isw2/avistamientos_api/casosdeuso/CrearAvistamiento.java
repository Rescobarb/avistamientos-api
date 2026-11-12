package com.isw2.avistamientos_api.casosdeuso;

import com.isw2.avistamientos_api.entidades.Avistamiento;
import com.isw2.avistamientos_api.entidades.ValidadorDeAvistamiento;

public class CrearAvistamiento {

    private final AvistamientoGateway gateway;
    private final ValidadorDeAvistamiento validador;

    public CrearAvistamiento(AvistamientoGateway gateway, ValidadorDeAvistamiento validador) {
        this.gateway = gateway;
        this.validador = validador;
    }

    public Avistamiento ejecutar(Avistamiento nuevo) {
        validador.validar(nuevo);
        nuevo.setId(null);
        return gateway.guardar(nuevo);
    }
}