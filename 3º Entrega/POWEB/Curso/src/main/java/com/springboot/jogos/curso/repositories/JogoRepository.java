package com.springboot.jogos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jogos.curso.entities.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long>{


}
