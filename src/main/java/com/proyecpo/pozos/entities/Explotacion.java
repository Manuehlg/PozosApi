package com.proyecpo.pozos.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Explotacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String ubicacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "explotacion", cascade = CascadeType.ALL)
    private List<Pozo> pozos;
}
