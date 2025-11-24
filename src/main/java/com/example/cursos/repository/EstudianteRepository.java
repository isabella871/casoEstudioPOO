package com.example.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cursos.entity.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante , Long>{
    
}
