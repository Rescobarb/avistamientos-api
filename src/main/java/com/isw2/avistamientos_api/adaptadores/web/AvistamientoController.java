package com.isw2.avistamientos_api.adaptadores.web;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.isw2.avistamientos_api.casosdeuso.ActualizarAvistamiento;
import com.isw2.avistamientos_api.casosdeuso.CrearAvistamiento;
import com.isw2.avistamientos_api.casosdeuso.EliminarAvistamiento;
import com.isw2.avistamientos_api.casosdeuso.ListarAvistamientos;
import com.isw2.avistamientos_api.casosdeuso.ResumenPorEspecie;
import com.isw2.avistamientos_api.casosdeuso.VerAvistamiento;
import com.isw2.avistamientos_api.entidades.Avistamiento;

@RestController
@RequestMapping("/avistamientos")
public class AvistamientoController {

    private final ListarAvistamientos listarAvistamientos;
    private final ResumenPorEspecie resumenPorEspecie;
    private final VerAvistamiento verAvistamiento;
    private final CrearAvistamiento crearAvistamiento;
    private final ActualizarAvistamiento actualizarAvistamiento;
    private final EliminarAvistamiento eliminarAvistamiento;

    public AvistamientoController(ListarAvistamientos listarAvistamientos,
            ResumenPorEspecie resumenPorEspecie,
            VerAvistamiento verAvistamiento,
            CrearAvistamiento crearAvistamiento,
            ActualizarAvistamiento actualizarAvistamiento,
            EliminarAvistamiento eliminarAvistamiento) {
        this.listarAvistamientos = listarAvistamientos;
        this.resumenPorEspecie = resumenPorEspecie;
        this.verAvistamiento = verAvistamiento;
        this.crearAvistamiento = crearAvistamiento;
        this.actualizarAvistamiento = actualizarAvistamiento;
        this.eliminarAvistamiento = eliminarAvistamiento;
    }

    @GetMapping
    public List<AvistamientoDto> listar() {
        return listarAvistamientos.ejecutar().stream().map(AvistamientoDto::desde).toList();
    }

    @GetMapping("/resumen")
    public Map<String, Long> resumen() {
        return resumenPorEspecie.ejecutar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvistamientoDto> ver(@PathVariable Long id) {
        return verAvistamiento.ejecutar(id)
                .map(AvistamientoDto::desde)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<AvistamientoDto> crear(@RequestBody AvistamientoDto cuerpo) {
        Avistamiento guardado = crearAvistamiento.ejecutar(cuerpo.aEntidad());
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/avistamientos/{id}").buildAndExpand(guardado.getId()).toUri();
        return ResponseEntity.created(location).body(AvistamientoDto.desde(guardado));
    }

    @PutMapping("/actualizar{id}")
    public ResponseEntity<AvistamientoDto> actualizar(@PathVariable Long id,
            @RequestBody AvistamientoDto cuerpo) {
        return actualizarAvistamiento.ejecutar(id, cuerpo.aEntidad())
                .map(AvistamientoDto::desde)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!eliminarAvistamiento.ejecutar(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}