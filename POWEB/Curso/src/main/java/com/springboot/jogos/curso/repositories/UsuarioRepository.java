package com.springboot.jogos.curso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.jogos.curso.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM Usuario WHERE id_usuario = ?1", nativeQuery = true)
	Usuario buscarPorId(@Param("id_usuario") Long id_usuario);

	@Query(value = "SELECT * FROM Usuario WHERE loginUsuario = ?1", nativeQuery = true)
	Usuario buscarPorLogin(@Param("loginUsuario") String loginUsuario);

	@Query(value = "SELECT * FROM Usuario", nativeQuery = true)
	List<Usuario> listarUsuarios();

}
