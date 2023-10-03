package com.mcescuela.pruebaescuela.services;

import com.mcescuela.pruebaescuela.config.DataBaseConfig;
import com.mcescuela.pruebaescuela.entities.Maestros;
import com.mcescuela.pruebaescuela.entities.Materias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class materiaService {
    private final DataBaseConfig dataBaseConfig;

    @Autowired
    public materiaService(DataBaseConfig dataBaseConfig) {
        this.dataBaseConfig = dataBaseConfig;
    }

    public void createMaestro(Materias materia) throws SQLException {
        dataBaseConfig.createMateria(materia);
    }

    public void updateMateria(Materias materia) throws SQLException {
        dataBaseConfig.updateMateria(materia);
    }

    public void deleteMateria(int id) throws SQLException {
        dataBaseConfig.deleteMateria(id);
    }

    public List<Materias> listarMaterias() {
        try {
            return dataBaseConfig.getAllMaterias();
        } catch (SQLException e) {
            // Manejar la excepción apropiadamente, por ejemplo, lanzar una excepción personalizada o registrar el error.
            throw new RuntimeException("Error al listar materias", e);
        }
    }
}
