package com.proyecpo.pozos.populators;

import com.proyecpo.pozos.entities.*;
import com.proyecpo.pozos.repositories.*;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
@ConditionalOnProperty(name = "spring.jpa.hibernate.ddl-auto", havingValue = "create")
public class Populator {

    private final UsuarioRepository usuarioRepository;
    private final ExplotacionRepository explotacionRepository;
    private final PozoRepository pozoRepository;
    private final CaracteristicasPozoRepository caracteristicasPozoRepository;
    private final MedicionesRepository medicionesRepository;

    public Populator(UsuarioRepository usuarioRepository,
                      ExplotacionRepository explotacionRepository,
                      PozoRepository pozoRepository,
                      CaracteristicasPozoRepository caracteristicasPozoRepository,
                      MedicionesRepository medicionesRepository) {
        this.usuarioRepository = usuarioRepository;
        this.explotacionRepository = explotacionRepository;
        this.pozoRepository = pozoRepository;
        this.caracteristicasPozoRepository = caracteristicasPozoRepository;
        this.medicionesRepository = medicionesRepository;
    }

    @PostConstruct
    public void populate() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Carlos");
        usuario.setApellido("Ramirez");
        usuario.setPassword("password123");
        usuario.setEmail("carlos.ramirez@example.com");
        usuario.setDireccion("Calle Pozos, 456");
        usuario.setMetodoPago("Tarjeta");
        usuarioRepository.save(usuario);

        Explotacion explotacion = new Explotacion();
        explotacion.setNombre("Explotacion Sur");
        explotacion.setUbicacion("Zona Sur");
        explotacion.setDescripcion("Campo agrícola de gran extensión");
        explotacion.setImagen("sur.jpg");
        explotacion.setUsuario(usuario);
        explotacionRepository.save(explotacion);

        CaracteristicasPozo caracteristicasPozo = new CaracteristicasPozo();
        caracteristicasPozo.setFechaMedicion(LocalDate.of(2025, 5, 1));
        caracteristicasPozo.setNivelIncialAgua(new BigDecimal("125.50"));
        caracteristicasPozo.setCalidadInicialAgua("Excelente");
        caracteristicasPozo.setObservaciones("Sin sedimentos visibles");
        caracteristicasPozoRepository.save(caracteristicasPozo);

        Pozo pozo = new Pozo();
        pozo.setNombre("Pozo Beta");
        pozo.setDescripcion("Pozo profundo de riego principal");
        pozo.setUbicacion("Sector B, parcela 3");
        pozo.setTipoPozo("Artesiano");
        pozo.setImagen("beta.png");
        pozo.setExplotacion(explotacion);
        pozo.setCaracteristicasPozo(caracteristicasPozo);
        pozoRepository.save(pozo);

        Mediciones medicion1 = new Mediciones();
        medicion1.setFechaMedicion(LocalDate.of(2025, 5, 10));
        medicion1.setCantidadAgua(new BigDecimal("450.00"));
        medicion1.setCalidadAgua("Buena");
        medicion1.setNivelAgua(new BigDecimal("122.00"));
        medicion1.setPozo(pozo);

        Mediciones medicion2 = new Mediciones();
        medicion2.setFechaMedicion(LocalDate.of(2025, 5, 17));
        medicion2.setCantidadAgua(new BigDecimal("470.00"));
        medicion2.setCalidadAgua("Buena");
        medicion2.setNivelAgua(new BigDecimal("121.00"));
        medicion2.setPozo(pozo);

        medicionesRepository.saveAll(List.of(medicion1, medicion2));
    }
}
