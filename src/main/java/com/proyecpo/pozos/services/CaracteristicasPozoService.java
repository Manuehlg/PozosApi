package com.proyecpo.pozos.services;

import com.proyecpo.pozos.entities.CaracteristicasPozo;
import com.proyecpo.pozos.repositories.CaracteristicasPozoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaracteristicasPozoService {

    @Autowired
    private CaracteristicasPozoRepository caracteristicasPozoRepository;

    public List<CaracteristicasPozo> getAll() {
        return caracteristicasPozoRepository.findAll();
    }

    public Optional<CaracteristicasPozo> getById(Long id) {
        return caracteristicasPozoRepository.findById(id);
    }

    public CaracteristicasPozo save(CaracteristicasPozo caracteristicasPozo) {
        return caracteristicasPozoRepository.save(caracteristicasPozo);
    }

    public void deleteById(Long id) {
        caracteristicasPozoRepository.deleteById(id);
    }
}
