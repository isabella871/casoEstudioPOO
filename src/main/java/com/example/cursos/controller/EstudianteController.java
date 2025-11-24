package com.example.cursos.controller;

import com.example.cursos.dto.EstudianteRequestDTO;
import com.example.cursos.dto.EstudianteResponseDTO;
import com.example.cursos.service.EstudianteService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estudiante")
public class EstudianteController {
    private final EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<EstudianteResponseDTO> crearEstudiante(@RequestBody EstudianteRequestDTO estudianteRequestDTO){
        EstudianteResponseDTO response = estudianteService.crearEstudiante(estudianteRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<EstudianteResponseDTO>> listarEstudiantes() {
        List<EstudianteResponseDTO> response = estudianteService.listarEstudiantes();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteResponseDTO> obtenerEstudiante(@PathVariable Long id) {
        EstudianteResponseDTO estudiante = estudianteService.buscarId(id).orElse(null);
        if (estudiante != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(estudiante);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        if (estudianteService.eliminarEstudiante(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteResponseDTO> actualizarEstudiante(@PathVariable Long id, @RequestBody EstudianteRequestDTO estudianteRequestDTO) {
        EstudianteResponseDTO actualizado = estudianteService.actualizarEstudiante(id, estudianteRequestDTO).orElse(null);
        if (actualizado != null) {
            return ResponseEntity.status(HttpStatus.OK).body(actualizado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
