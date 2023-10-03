package com.mcescuela.pruebaescuela.controllers;

import com.mcescuela.pruebaescuela.entities.Maestros;
import com.mcescuela.pruebaescuela.services.maestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/maestros")
public class maestroController {
    private final maestroService maestroService;
    @Autowired
    public maestroController(maestroService maestroService) {
        this.maestroService = maestroService;
    }
    @PostMapping("/insertar")
    public ResponseEntity<String> insertarMaestro(@RequestBody Maestros maestro) {
        try {
            maestroService.createMaestro(maestro);
            return ResponseEntity.ok("Maestro insertado correctamente");
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Error al insertar maestro: " + e.getMessage());
        }
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<String> modificarMaestro(@PathVariable Long id, @RequestBody Maestros maestro) {
        maestro.setIdMaestro(id);
        try {
            maestroService.updateMaestro(maestro);
            return ResponseEntity.ok("Maestro actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el maestro: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{idMaestro}")
    public ResponseEntity<String> eliminarMaestro(@PathVariable int idMaestro) {
        try {
            maestroService.deleteMaestro(idMaestro);
            return ResponseEntity.ok("Maestro eliminado correctamente");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el maestro");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Maestros>> listarMaestros() {
        List<Maestros> maestros = maestroService.listarMaestros();
        return new ResponseEntity<>(maestros, HttpStatus.OK);
    }

}
