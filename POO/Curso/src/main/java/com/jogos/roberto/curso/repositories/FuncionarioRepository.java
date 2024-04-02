package com.jogos.roberto.curso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jogos.roberto.curso.entities.Funcionario;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	@Query(value = "SELECT * FROM funcionario WHERE id_funcionario = ?1", nativeQuery = true)
	Funcionario buscarPorID(Long id_funcionario);

	@Query(value = "SELECT * FROM funcionario WHERE cpf = ?1", nativeQuery = true)
	Funcionario buscarPorCPF(String cpf);
	
	@Query(value = "SELECT * FROM funcionario WHERE login = ?1", nativeQuery = true)
	Funcionario buscarPorLogin(String login);

	@Query(value = "SELECT * FROM funcionario WHERE senha = ?1", nativeQuery = true)
	Funcionario buscarPorSenha(String senha);

	@Query(value = "SELECT * FROM funcionario", nativeQuery = true)
	List<Funcionario> listarFuncionario();

    
}