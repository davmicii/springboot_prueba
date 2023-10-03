package com.mcescuela.pruebaescuela.controllers;

import com.mcescuela.pruebaescuela.entities.Maestros;
import com.mcescuela.pruebaescuela.entities.Materias;
import com.mcescuela.pruebaescuela.services.materiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/materias")
public class materiaController {
    private final materiaService materiaService;
    @Autowired
    public materiaController(materiaService materiaService) {
        this.materiaService = materiaService;
    }
    @PostMapping("/insertar")
    public ResponseEntity<String> insertarMaestro(@RequestBody Materias materia) {
        try {
            materiaService.createMaestro(materia);
            return ResponseEntity.ok("Materia insertado correctamente");
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Error al insertar materia: " + e.getMessage());
        }
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<String> modificarMateria(@PathVariable Long id, @RequestBody Materias materia) {
        materia.setIdMateria(id);
        try {
            materiaService.updateMateria(materia);
            return ResponseEntity.ok("Materia actualizada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar materia: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{idMateria}")
    public ResponseEntity<String> eliminarMateria(@PathVariable int idMateria) {
        try {
            materiaService.deleteMateria(idMateria);
            return ResponseEntity.ok("Materia eliminado correctamente");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar materia");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Materias>> listarMaterias() {
        List<Materias> materia = materiaService.listarMaterias();
        return new ResponseEntity<>(materia, HttpStatus.OK);
    }

}
