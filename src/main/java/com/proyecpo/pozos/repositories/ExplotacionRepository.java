package com.proyecpo.pozos.repositories;

import com.proyecpo.pozos.entities.Explotacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExplotacionRepository extends JpaRepository<Explotacion, Long> {
    List<Explotacion> findByUsuarioId(Long usuarioId);
}
