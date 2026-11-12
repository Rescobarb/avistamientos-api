package com.isw2.avistamientos_api.casosdeuso;

public class EliminarAvistamiento {

    private final AvistamientoGateway gateway;

    public EliminarAvistamiento(AvistamientoGateway gateway) {
        this.gateway = gateway;
    }

    /** Devuelve false si el avistamiento no existía. */
    public boolean ejecutar(Long id) {
        if (!gateway.existe(id)) {
            return false;
        }
        gateway.eliminar(id);
        return true;
    }
}