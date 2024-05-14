package com.jogos.roberto.curso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jogos.roberto.curso.entities.Jogo;
import com.jogos.roberto.curso.entities.Plataforma;


public interface JogoRepository extends JpaRepository<Jogo, Long>{

    @Query(value = "SELECT * FROM Jogo WHERE id_jogo = ?1", nativeQuery = true)
    Jogo buscarPorId(@Param("id_jogo") Long id_jogo);

    @Query(value = "SELECT * FROM Jogo WHERE nome = ?1", nativeQuery = true)
    Jogo buscarPorNome(@Param("nome") String nome);

    @Query(value = "SELECT * FROM Jogo", nativeQuery = true)
    List<Jogo> listarJogos();
    
    Jogo findByNomeAndPlataforma(String nome, Plataforma plataforma);

    /*
    @Query(value = "SELECT * FROM Jogo WHERE nome = ?1 AND plataforma = ?2", nativeQuery = true)
    Jogo findByNomeAndPlataforma(@Param("nome") String nome, @Param("plataforma") Plataforma plataforma);
	*/
    
    /*
    @Query(value = "SELECT * FROM Jogo WHERE nome = :nome AND plataforma = :plataforma", nativeQuery = true)
    Jogo findByNomeAndPlataforma(@Param("nome") String nome, @Param("plataforma") Plataforma plataforma);
 */
    
    boolean existsByNomeAndPlataforma(String nome, Plataforma plataforma);

    /*
    Jogo findById(long id_jogo);

    Jogo findByNome(String nome);

    List<Jogo> findAll();
*/

}