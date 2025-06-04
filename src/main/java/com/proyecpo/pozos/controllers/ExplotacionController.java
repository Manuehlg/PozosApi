package com.proyecpo.pozos.controllers;

import com.proyecpo.pozos.entities.Explotacion;
import com.proyecpo.pozos.repositories.ExplotacionRepository;
import com.proyecpo.pozos.services.ExplotacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/explotaciones")
public class ExplotacionController {

    @Autowired
    private ExplotacionService explotacionService;

    @GetMapping("/usuario/{usuarioId}")
    public List<Explotacion> getByUsuario(@PathVariable Long usuarioId) {
        return explotacionService.getByUsuarioId(usuarioId);
    }

    @PostMapping
    public Explotacion create(@RequestBody Explotacion explotacion) {
        return explotacionService.save(explotacion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        explotacionService.delete(id);
    }

    @GetMapping
    public List<Explotacion> getAll() {
        return explotacionService.getAll();
    }

}

