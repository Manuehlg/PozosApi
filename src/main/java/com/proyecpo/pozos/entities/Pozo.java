package com.proyecpo.pozos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Pozo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nombre;
    @NotNull
    private String caracteristicas;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private CaracteristicasPozo caracteristicasPozo;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private MedicionesPozo medicionesPozo;

    @ManyToOne
    @JoinColumn(name = "explotacion_id")
    private Explotacion explotacion;
}

