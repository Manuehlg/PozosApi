package com.proyecpo.pozos.services;

import com.proyecpo.pozos.entities.Pozo;
import com.proyecpo.pozos.repositories.PozoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PozoService {

    @Autowired
    private PozoRepository pozoRepository;

    public List<Pozo> getByExplotacionId(Long explotacionId) {
        return pozoRepository.findByExplotacionId(explotacionId);
    }

    public Pozo save(Pozo pozo) {
        return pozoRepository.save(pozo);
    }

    public void delete(Long id) {
        pozoRepository.deleteById(id);
    }
}
