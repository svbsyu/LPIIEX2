package com.cibertec.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.app.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, String>{

}
