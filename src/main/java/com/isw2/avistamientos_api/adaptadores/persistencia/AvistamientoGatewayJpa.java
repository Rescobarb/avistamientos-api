package com.isw2.avistamientos_api.adaptadores.persistencia;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.isw2.avistamientos_api.casosdeuso.AvistamientoGateway;
import com.isw2.avistamientos_api.entidades.Avistamiento;

@Component
public class AvistamientoGatewayJpa implements AvistamientoGateway {

    private final AvistamientoRepository repositorio;

    public AvistamientoGatewayJpa(AvistamientoRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Avistamiento> listar() {
        return repositorio.findAll().stream().map(this::aDominio).toList();
    }

    @Override
    public Optional<Avistamiento> buscarPorId(Long id) {
        return repositorio.findById(id).map(this::aDominio);
    }

    @Override
    public Avistamiento guardar(Avistamiento avistamiento) {
        return aDominio(repositorio.save(aJpa(avistamiento)));
    }

    @Override
    public boolean existe(Long id) {
        return repositorio.existsById(id);
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

    private Avistamiento aDominio(AvistamientoModelo m) {
        return new Avistamiento(m.getId(), m.getEspecie(), m.getUbicacion(), m.getFecha(), m.getObservador());
    }

    private AvistamientoModelo aJpa(Avistamiento a) {
        AvistamientoModelo m = new AvistamientoModelo(a.getEspecie(), a.getLugar(), a.getFecha(), a.getObservador());
        m.setId(a.getId());
        return m;
    }
}