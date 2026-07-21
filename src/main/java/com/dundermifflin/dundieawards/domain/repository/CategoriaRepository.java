package com.dundermifflin.dundieawards.domain.repository;

import com.dundermifflin.dundieawards.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByCerimoniaId(Long cerimoniaId);
}