package com.springboot.jogos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jogos.curso.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
