package com.mcescuela.pruebaescuela.repository;

import com.mcescuela.pruebaescuela.entities.Maestros;
import org.springframework.data.repository.CrudRepository;

public interface MaestroRepository extends CrudRepository<Maestros, Long> {
}
