package com.jogos.roberto.curso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jogos.roberto.curso.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
    @Query(value = "SELECT * FROM empresa WHERE nome_empresa =?1", nativeQuery = true)
    Empresa buscarPorNome(@Param("nome_empresa") String nome_empresa);

    @Query(value = "SELECT * FROM empresa", nativeQuery = true)
    List<Empresa> findAll();
    
}
