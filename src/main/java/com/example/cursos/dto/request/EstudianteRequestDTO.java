package com.example.cursos.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EstudianteRequestDTO {
    @Size(min = 3, max = 30)
    private String nombre;

    @Email
    private String email;
}
