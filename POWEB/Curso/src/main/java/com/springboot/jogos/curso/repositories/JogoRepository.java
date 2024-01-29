package com.springboot.jogos.curso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.jogos.curso.entities.Jogo;
import com.springboot.jogos.curso.entities.Plataforma;

public interface JogoRepository extends JpaRepository<Jogo, Long>{

    @Query(value = "SELECT * FROM Jogo WHERE id = ?1", nativeQuery = true)
    Jogo buscarPorId(@Param("id_jogo") Long id_jogo);

    @Query(value = "SELECT * FROM Jogo WHERE nome = ?1", nativeQuery = true)
    Jogo buscarPorNome(@Param("nome") String nome);

    @Query(value = "SELECT * FROM Jogo", nativeQuery = true)
    List<Jogo> listarJogos();

    @Query(value = "SELECT * FROM Jogo WHERE nome = :nome AND plataforma = :plataforma", nativeQuery = true)
    Jogo findByNomeAndPlataforma(@Param("nome") String nome, @Param("plataforma") Plataforma plataforma);


    /*
    Jogo findById(long id_jogo);

    Jogo findByNome(String nome);

    List<Jogo> findAll();
*/

}
