package com.example.exerciciossb.model.repositories;

import com.example.exerciciossb.model.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
