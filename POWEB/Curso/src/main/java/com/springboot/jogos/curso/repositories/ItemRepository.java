package com.springboot.jogos.curso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.jogos.curso.entities.Item;

public interface  ItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "SELECT * FROM Item WHERE id = ?1", nativeQuery = true)
    Item buscarPorId(Long id_item);
    
    @Query(value = "SELECT * FROM Item", nativeQuery = true)
    List<Item> listarItens();

}
