package com.proyecpo.pozos.repositories;

import com.proyecpo.pozos.entities.Mediciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicionesRepository extends JpaRepository<Mediciones, Long> {
    List<Mediciones> findByPozoId(Long pozoId);
    void deleteById(Long id);

}
