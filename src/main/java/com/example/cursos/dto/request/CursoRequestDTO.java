package com.example.cursos.dto.request;

import lombok.Data;

//Datos que se envían

@Data
public class CursoRequestDTO {
    private String titulo;
    private String descripcion;
    private Long idCategoria;
}
