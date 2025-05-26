package com.proyecpo.pozos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Mediciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate fechaMedicion;
    @NotNull
    private BigDecimal cantidadAgua;
    @NotNull
    private String calidadAgua;
    @NotNull
    private BigDecimal nivelAgua;

    @ManyToOne
    @JoinColumn(name = "pozo_id")
    private Pozo pozo;
}