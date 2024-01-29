package com.springboot.jogos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jogos.curso.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    

}
