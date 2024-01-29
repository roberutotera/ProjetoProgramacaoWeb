package com.springboot.jogos.curso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.jogos.curso.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT * FROM Cliente WHERE id = ?1", nativeQuery = true)
    Cliente buscarPorId(Long id_usuario);

    @Query(value = "SELECT * FROM Cliente WHERE cpf = ?1", nativeQuery = true)
    Cliente buscarPorCPF(String cpf);
    
    @Query(value = "SELECT CASE WHEN EXISTS (SELECT 1 FROM Cliente c JOIN c.telefones t WHERE c.cpf = ?1 AND ?2 IN elements(t)) THEN true ELSE false END")
    boolean existeTelefoneNoCPF(String cpf, String telefone);
    
	@Query(value = "SELECT * FROM Cliente", nativeQuery = true)
	List<Cliente> listarClientes();

    @Query("SELECT COUNT(c) > 0 FROM Cliente c WHERE c.cpf = :cpf")
    boolean existsByCpf(String cpf);
}
