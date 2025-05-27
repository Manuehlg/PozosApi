package com.proyecpo.pozos.services;

import com.proyecpo.pozos.entities.Mediciones;
import com.proyecpo.pozos.repositories.MedicionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicionesService {

    @Autowired
    private MedicionesRepository medicionesRepository;

    public List<Mediciones> getAll() {
        return medicionesRepository.findAll();
    }

    public List<Mediciones> getByPozoId(Long pozoId) {
        return medicionesRepository.findByPozoId(pozoId);
    }

    public Optional<Mediciones> getById(Long id) {
        return medicionesRepository.findById(id);
    }

    public Mediciones save(Mediciones mediciones) {
        return medicionesRepository.save(mediciones);
    }

    public void deleteById(Long id) {
        medicionesRepository.deleteById(id);
    }

}
