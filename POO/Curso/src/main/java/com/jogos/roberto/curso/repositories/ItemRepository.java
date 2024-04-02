package com.jogos.roberto.curso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jogos.roberto.curso.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "SELECT * FROM Item WHERE id_item = ?1", nativeQuery = true)
    Item buscarPorId(Long id_item);

	@Query("SELECT i FROM Item i")
	List<Item> listarItens();

}