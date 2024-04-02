package com.jogos.roberto.curso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jogos.roberto.curso.entities.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Query(value = "SELECT * FROM Pedido WHERE id_pedido = ?1", nativeQuery = true)
	Pedido buscarPorId(Long id_pedido);

    @Query("SELECT p FROM Pedido p JOIN p.itens i WHERE i.jogo.id_jogo = :id_jogo")
    List<Pedido> buscarPorJogoId(Long id_jogo);

	@Query(value = "SELECT * FROM Pedido WHERE id_cliente = ?1 AND finalizado = false", nativeQuery = true)
	List<Pedido> buscarPedidosEmProgresso(Long id_cliente);
	
	@Query(value = "SELECT * FROM Pedido WHERE id_cliente = ?1 AND finalizado = true", nativeQuery = true)
	List<Pedido> buscarPedidosFinalizados(Long id_cliente);

	@Query(value = "SELECT * FROM Pedido WHERE id_cliente = ?1", nativeQuery = true)
	List<Pedido> buscarPedidosDoCliente(Long id_cliente);
	
	@Query(value = "SELECT * FROM Pedido", nativeQuery = true)
	List<Pedido> listarPedidos();
}
