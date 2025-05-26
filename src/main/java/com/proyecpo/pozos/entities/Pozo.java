package com.proyecpo.pozos.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Pozo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private String ubicacion;

    private String tipoPozo;

    private String imagen;


    @ManyToOne
    @JoinColumn(name = "explotacion_id")
    private Explotacion explotacion;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "caracteristicas_pozo_id")
    private CaracteristicasPozo caracteristicasPozo;

    @OneToMany(mappedBy = "pozo", cascade = CascadeType.ALL)
    private List<Mediciones> mediciones;
}

