package com.springboot.jogos.curso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.jogos.curso.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

     @Query(value = "SELECT * FROM Pedido WHERE id = ?1", nativeQuery = true)
    Pedido buscarPorId(Long id_pedido);
    
	@Query(value="SELECT id_usuario FROM Pedido WHERE id = ?1", nativeQuery = true)
    Long buscarPedidoPeloClienteId(Long id_usuario);

	@Query(value="SELECT * FROM Pedido WHERE id = ?1 AND finalizado = false", nativeQuery = true)
	List<Pedido> buscarPedidosEmProgresso(Long id);

    @Query(value = "SELECT * FROM Pedido", nativeQuery = true)
    List<Pedido> listarPedidos();
    
}
