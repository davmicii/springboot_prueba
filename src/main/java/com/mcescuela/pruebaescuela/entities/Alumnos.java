package com.mcescuela.pruebaescuela.entities;

import jakarta.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;


@Table("Alumno")
public class Alumnos {
    @Id
    private Long idAlumno;
    @Column("nombre")
    private String nombre;
    @Column("apellido")
    private String apellido;

    // Relación "uno a muchos" con Maestro
    private Maestros maestro;

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Maestros getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestros maestro) {
        this.maestro = maestro;
    }
}
