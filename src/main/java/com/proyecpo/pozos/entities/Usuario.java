package com.proyecpo.pozos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String password;
    @NotNull
    private String correo;
    @OneToMany(mappedBy = "Usuario", cascade = CascadeType.ALL)
    private List<Explotacion> explotaciones;

}
