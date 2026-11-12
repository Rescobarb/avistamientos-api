package com.isw2.avistamientos_api.validacion;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class RelojSistema implements Reloj {
    @Override
    public LocalDate hoy() {
        return LocalDate.now();
    }
}