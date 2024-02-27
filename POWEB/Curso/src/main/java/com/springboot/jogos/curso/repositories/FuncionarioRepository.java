package com.springboot.jogos.curso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.jogos.curso.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query(value = "SELECT * FROM Funcionario WHERE id = ?1", nativeQuery = true)
    Funcionario buscarPorId(Long id_usuario);

    @Query("SELECT COUNT(f) > 0 FROM Funcionario f WHERE f.cpf = :cpf")
    boolean existsByCpf(String cpf);

    @Query(value = "SELECT * FROM Funcionario WHERE nome = ?1", nativeQuery = true)
    Funcionario buscarPorNome(String nome);
    
    @Query(value = "SELECT CASE WHEN EXISTS (SELECT 1 FROM Funcionario c JOIN c.telefones t WHERE c.cpf = :cpf AND :telefone IN elements(t)) THEN true ELSE false END")
    boolean existeTelefoneNoCPF(String cpf, String telefone);
    
    @Query(value = "SELECT * FROM Funcionario", nativeQuery = true)
    List<Funcionario> listarFuncionarios();

    

}
