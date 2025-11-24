package com.example.cursos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cursos.dto.CursoRequestDTO;
import com.example.cursos.dto.CursoResponseDTO;
import com.example.cursos.service.CursoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/curso")
public class CursoController {
    private final CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoResponseDTO> crearCurso(@RequestBody CursoRequestDTO cursoRequestDTO){
        CursoResponseDTO response = cursoService.crearCurso(cursoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CursoResponseDTO>> listarUsuarios() {
        List<CursoResponseDTO> response = cursoService.listarCursos();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> obtenerUsuario(@PathVariable Long id) {
        CursoResponseDTO cursoResponseDTO = cursoService.buscarId(id).orElse(null);
        if (cursoResponseDTO != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(cursoResponseDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        if (cursoService.eliminarCurso(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> actualizarUsuario(@PathVariable Long id, @RequestBody CursoRequestDTO cursoRequestDTO) {
        CursoResponseDTO cursoActualizado = cursoService.actualizarCurso(id, cursoRequestDTO).orElse(null);
        if (cursoActualizado != null) {
            return ResponseEntity.status(HttpStatus.OK).body(cursoActualizado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
