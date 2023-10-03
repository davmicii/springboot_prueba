package com.mcescuela.pruebaescuela.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("Alumno_has_Materias")
public class AlumnosMaterias {
    @Id
    private Long id;

    private Alumnos alumno;
    private Materias materia;
}
