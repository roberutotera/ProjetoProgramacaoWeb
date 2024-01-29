package com.springboot.jogos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jogos.curso.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
