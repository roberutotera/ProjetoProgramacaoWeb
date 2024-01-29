package com.springboot.jogos.curso.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jogos.curso.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
