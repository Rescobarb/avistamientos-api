package com.isw2.avistamientos_api.adaptadores.web;

import java.time.LocalDate;

import com.isw2.avistamientos_api.entidades.Avistamiento;

public record AvistamientoDto(Long id, String especie, String lugar, LocalDate fecha, String observador) {

    static AvistamientoDto desde(Avistamiento a) {
        return new AvistamientoDto(a.getId(), a.getEspecie(), a.getLugar(), a.getFecha(), a.getObservador());
    }

    Avistamiento aEntidad() {
        return new Avistamiento(id, especie, lugar, fecha, observador);
    }
}