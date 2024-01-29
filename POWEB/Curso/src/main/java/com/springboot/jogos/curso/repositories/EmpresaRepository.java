package com.springboot.jogos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.jogos.curso.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query("SELECT COUNT(e) > 0 FROM Empresa e WHERE e.nome_empresa = :nomeEmpresa")
    boolean existsByNomeEmpresa(String nomeEmpresa);

}
