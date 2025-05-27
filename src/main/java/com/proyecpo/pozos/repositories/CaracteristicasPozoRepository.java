package com.proyecpo.pozos.repositories;

import com.proyecpo.pozos.entities.CaracteristicasPozo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface CaracteristicasPozoRepository extends JpaRepository<CaracteristicasPozo, Long> {

}
