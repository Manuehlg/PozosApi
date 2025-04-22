package com.proyecpo.pozos.controllers;

import com.proyecpo.pozos.entities.Pozo;
import com.proyecpo.pozos.repositories.PozoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pozos")
public class PozoController {
    @Autowired
    private PozoRepository pozoRepo;

    @GetMapping("/explotacion/{explotacionId}")
    public List<Pozo> getByExplotacion(@PathVariable Long explotacionId) {
        return pozoRepo.findByExplotacionId(explotacionId);
    }

    @PostMapping
    public Pozo create(@RequestBody Pozo pozo) {
        return pozoRepo.save(pozo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pozoRepo.deleteById(id);
    }
}
