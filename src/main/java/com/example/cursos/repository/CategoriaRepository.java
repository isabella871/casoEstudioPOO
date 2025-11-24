package com.example.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cursos.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
