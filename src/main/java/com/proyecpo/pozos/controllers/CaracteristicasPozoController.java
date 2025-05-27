package com.proyecpo.pozos.controllers;

import com.proyecpo.pozos.entities.CaracteristicasPozo;
import com.proyecpo.pozos.repositories.CaracteristicasPozoRepository;
import com.proyecpo.pozos.services.CaracteristicasPozoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/caracteristicas-pozo")
public class CaracteristicasPozoController {

    @Autowired
    private CaracteristicasPozoService caracteristicasPozoService;

    @GetMapping
    public List<CaracteristicasPozo> getAll() {
        return caracteristicasPozoService.getAll();
    }

    @PostMapping
    public CaracteristicasPozo create(@Valid @RequestBody CaracteristicasPozo caracteristicasPozo) {
        return caracteristicasPozoService.save(caracteristicasPozo);
    }

    @PutMapping("/{id}")
    public CaracteristicasPozo update(@PathVariable Long id, @Valid @RequestBody CaracteristicasPozo updated) {
        CaracteristicasPozo existing = caracteristicasPozoService.getById(id).orElseThrow();
        existing.setFechaMedicion(updated.getFechaMedicion());
        existing.setNivelIncialAgua(updated.getNivelIncialAgua());
        existing.setCalidadInicialAgua(updated.getCalidadInicialAgua());
        existing.setObservaciones(updated.getObservaciones());
        return caracteristicasPozoService.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        caracteristicasPozoService.deleteById(id);
    }
}
