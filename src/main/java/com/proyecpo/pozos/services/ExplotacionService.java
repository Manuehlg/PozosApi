package com.proyecpo.pozos.services;

import com.proyecpo.pozos.dto.ExplotacionDTO;
import com.proyecpo.pozos.entities.Explotacion;
import com.proyecpo.pozos.repositories.ExplotacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExplotacionService {

    @Autowired
    private ExplotacionRepository explotacionRepository;

    public List<Explotacion> getByUsuarioId(Long usuarioId) {
        return explotacionRepository.findByUsuarioId(usuarioId);
    }

    public Explotacion save(Explotacion explotacion) {
        return explotacionRepository.save(explotacion);
    }

    public void delete(Long id) {
        explotacionRepository.deleteById(id);
    }
    public List<Explotacion> getAll() {
        return explotacionRepository.findAll();
    }
    public List<ExplotacionDTO> getAllDTOs() {
        return explotacionRepository.findAll().stream()
                .map(exp ->
                        new ExplotacionDTO(
                        exp.getId(),
                        exp.getNombre(),
                        exp.getUbicacion(),
                        exp.getDescripcion(),
                        exp.getImagen()
                ))
                .toList();
    }

}
