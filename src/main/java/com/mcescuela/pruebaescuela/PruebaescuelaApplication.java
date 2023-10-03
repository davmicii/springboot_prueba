package com.mcescuela.pruebaescuela;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
//@ComponentScan(basePackages = "com.mcescuela.pruebaescuela.config")
public class PruebaescuelaApplication {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(PruebaescuelaApplication.class, args);
	}

	@PostConstruct
	public void createTables() {
		jdbcTemplate.execute(
				"IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Maestro') " +
						"CREATE TABLE Maestro (idMaestro INT IDENTITY(1,1) PRIMARY KEY, nombre VARCHAR(255), apellido VARCHAR(255), titulo VARCHAR(255))"
		);

		jdbcTemplate.execute(
				"IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Materia') " +
						"CREATE TABLE Materia (idMateria INT IDENTITY(1,1) PRIMARY KEY, Descripcion VARCHAR(255), Puntos VARCHAR(255))"
		);

		jdbcTemplate.execute(
				"IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Alumnos') " +
						"CREATE TABLE Alumnos (idAlumno INT IDENTITY(1,1) PRIMARY KEY, nombre VARCHAR(255), apellido VARCHAR(255), Maestro_Id INT, FOREIGN KEY (Maestro_Id) REFERENCES Maestro(idMaestro))"
		);

		jdbcTemplate.execute(
				"IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Alumno_has_Materias') " +
						"CREATE TABLE Alumno_has_Materias (Alumno_id INT, Materia_id INT, FOREIGN KEY (Alumno_id) REFERENCES Alumnos(idAlumno), FOREIGN KEY (Materia_id) REFERENCES Materia(idMateria))"
		);
	}
}
