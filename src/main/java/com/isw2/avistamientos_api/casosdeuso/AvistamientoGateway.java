package com.isw2.avistamientos_api.casosdeuso;

import java.util.List;
import java.util.Optional;

import com.isw2.avistamientos_api.entidades.Avistamiento;

public interface AvistamientoGateway {

    List<Avistamiento> listar();

    Optional<Avistamiento> buscarPorId(Long id);

    Avistamiento guardar(Avistamiento avistamiento);

    boolean existe(Long id);

    void eliminar(Long id);
}