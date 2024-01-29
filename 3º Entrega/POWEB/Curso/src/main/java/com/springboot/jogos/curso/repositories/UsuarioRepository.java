package com.springboot.jogos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jogos.curso.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
