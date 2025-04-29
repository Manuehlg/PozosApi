package com.proyecpo.pozos.services;

import com.proyecpo.pozos.entities.Cuenta;
import com.proyecpo.pozos.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    public Optional<Cuenta> login(String email, String password){
        return cuentaRepository.findByEmail(email)
                .filter(cuenta -> cuenta.getPassword().equals(password));
    }
    public Cuenta save(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public List<Cuenta> getAll() {
        return cuentaRepository.findAll();
    }

    public Optional<Cuenta> findById(Long id) {
        return cuentaRepository.findById(id);
    }

    public void delete(Long id) {
        cuentaRepository.deleteById(id);
    }
}
