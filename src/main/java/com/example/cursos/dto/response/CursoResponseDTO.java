package com.example.cursos.dto.response;

import lombok.Data;

// Datos que el servidor responde

@Data
public class CursoResponseDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private String categoria;
}
