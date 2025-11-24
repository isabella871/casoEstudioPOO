package com.example.cursos.controller;

import com.example.cursos.dto.CategoriaRequestDTO;
import com.example.cursos.dto.CategoriaResponseDTO;
import com.example.cursos.service.CategoriaService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> crearCategoria(@RequestBody CategoriaRequestDTO categoriaRequestDTO){
        CategoriaResponseDTO response = categoriaService.crearCategoria(categoriaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> listarCategorias() {
        List<CategoriaResponseDTO> response = categoriaService.listarCategorias();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> obtenerCategoria(@PathVariable Long id) {
        CategoriaResponseDTO categoriaResponseDTO = categoriaService.buscarId(id).orElse(null);
        if (categoriaResponseDTO != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(categoriaResponseDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        if (categoriaService.eliminarCategoria(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaRequestDTO categoriaRequestDTO) {
        CategoriaResponseDTO categoriaActualizada = categoriaService.actualizarCategoria(id, categoriaRequestDTO).orElse(null);
        if (categoriaActualizada != null) {
            return ResponseEntity.status(HttpStatus.OK).body(categoriaActualizada);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
