package com.mcescuela.pruebaescuela.services;

import com.mcescuela.pruebaescuela.config.DataBaseConfig;
import com.mcescuela.pruebaescuela.entities.Maestros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
public class maestroService {
    private final DataBaseConfig dataBaseConfig;

    @Autowired
    public maestroService(DataBaseConfig dataBaseConfig) {
        this.dataBaseConfig = dataBaseConfig;
    }

    public void createMaestro(Maestros maestro) throws SQLException {
        dataBaseConfig.createMaestro(maestro);
    }

    public void updateMaestro(Maestros maestro) throws SQLException {
        dataBaseConfig.updateMaestro(maestro);
    }

    public void deleteMaestro(int id) throws SQLException {
        dataBaseConfig.deleteMaestro(id);
    }

    public List<Maestros> listarMaestros() {
        try {
            return dataBaseConfig.getAllMaestros();
        } catch (SQLException e) {
            // Manejar la excepción apropiadamente, por ejemplo, lanzar una excepción personalizada o registrar el error.
            throw new RuntimeException("Error al listar maestros", e);
        }
    }

}
