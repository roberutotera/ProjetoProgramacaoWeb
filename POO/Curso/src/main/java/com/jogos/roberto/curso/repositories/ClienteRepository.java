package com.jogos.roberto.curso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jogos.roberto.curso.entities.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query(value = "SELECT * FROM cliente WHERE id_cliente = ?1", nativeQuery = true)
	Cliente buscarPorID(Long id_cliente);

	@Query(value = "SELECT * FROM cliente WHERE cpf = ?1", nativeQuery = true)
	Cliente buscarPorCPF(String cpf);

	@Query(value = "SELECT * FROM cliente", nativeQuery = true)
	List<Cliente> listarClientes();

    
}