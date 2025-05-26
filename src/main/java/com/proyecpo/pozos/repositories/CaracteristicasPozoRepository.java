package com.proyecpo.pozos.repositories;

import com.proyecpo.pozos.entities.CaracteristicasPozo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface CaracteristicasPozoRepository extends JpaRepository<CaracteristicasPozo, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    CaracteristicasPozo findByPozoId(Long pozoId);
    void deleteById(Long id);
    void deleteByPozoId(Long pozoId);
    boolean existsByPozoId(Long pozoId);
    boolean existsById(Long id);
    CaracteristicasPozo save(CaracteristicasPozo caracteristicasPozo);
    CaracteristicasPozo findByFechaMedicion(LocalDate fechaMedicion);
    CaracteristicasPozo findByNivelIncialAgua(BigDecimal nivelIncialAgua);
}
