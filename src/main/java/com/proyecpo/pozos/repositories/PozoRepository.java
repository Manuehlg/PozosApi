package com.proyecpo.pozos.repositories;

import com.proyecpo.pozos.entities.Pozo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PozoRepository extends JpaRepository<Pozo, Long> {

    List<Pozo> findByExplotacionId(Long explotacionId);

}
