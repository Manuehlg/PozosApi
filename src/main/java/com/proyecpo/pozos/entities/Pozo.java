package com.proyecpo.pozos.entities;

import jakarta.persistence.*;

@Entity
public class Pozo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String caracteristicas;

    @ManyToOne
    @JoinColumn(name = "explotacion_id")
    private Explotacion explotacion;
}

