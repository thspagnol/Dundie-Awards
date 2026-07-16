package com.dundermifflin.dundieawards.domain.repository;

import com.dundermifflin.dundieawards.domain.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}