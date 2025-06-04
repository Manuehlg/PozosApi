package com.proyecpo.pozos.controllers;

import com.proyecpo.pozos.entities.Mediciones;
import com.proyecpo.pozos.repositories.MedicionesRepository;
import com.proyecpo.pozos.services.MedicionesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/mediciones")
public class MedicionesController {

    @Autowired
    private MedicionesService medicionesService;

    @GetMapping
    public List<Mediciones> getAll() {
        return medicionesService.getAll();
    }

    @GetMapping("/pozo/{pozoId}")
    public List<Mediciones> getByPozo(@PathVariable Long pozoId) {
        return medicionesService.getByPozoId(pozoId);
    }

    @PostMapping
    public Mediciones create(@Valid @RequestBody Mediciones medicion) {
        return medicionesService.save(medicion);
    }

    @PutMapping("/{id}")
    public Mediciones update(@PathVariable Long id, @Valid @RequestBody Mediciones updated) {
        Mediciones existing = medicionesService.getById(id).orElseThrow();
        existing.setCantidadAgua(updated.getCantidadAgua());
        existing.setFechaMedicion(updated.getFechaMedicion());
        existing.setCalidadAgua(updated.getCalidadAgua());
        existing.setNivelAgua(updated.getNivelAgua());
        return medicionesService.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        medicionesService.deleteById(id);
    }
}
