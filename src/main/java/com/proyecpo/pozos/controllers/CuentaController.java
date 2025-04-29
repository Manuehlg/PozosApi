package com.proyecpo.pozos.controllers;

import com.proyecpo.pozos.entities.Cuenta;
import com.proyecpo.pozos.services.CuentaService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Data
@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Optional<Cuenta> cuenta = cuentaService.login(email, password);
        return cuenta.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas"));
    }

    @PostMapping
    public ResponseEntity<Cuenta> create(@RequestBody Cuenta cuenta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cuentaService.save(cuenta));
    }

    @GetMapping
    public List<Cuenta> getAll() {
        return cuentaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> getById(@PathVariable Long id) {
        return cuentaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cuentaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

