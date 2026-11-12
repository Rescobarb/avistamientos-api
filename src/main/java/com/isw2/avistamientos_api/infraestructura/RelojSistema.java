package com.isw2.avistamientos_api.infraestructura;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.isw2.avistamientos_api.entidades.Reloj;

@Component
public class RelojSistema implements Reloj {
    @Override
    public LocalDate hoy() {
        return LocalDate.now();
    }
}