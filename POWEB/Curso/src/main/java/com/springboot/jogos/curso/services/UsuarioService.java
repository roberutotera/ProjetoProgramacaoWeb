package com.springboot.jogos.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jogos.curso.entities.Usuario;
import com.springboot.jogos.curso.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
	private UsuarioRepository usuarioRepository;

	public String deletarUsuario(Long id_usuario) {
		Usuario usuarioExistente = usuarioRepository.buscarPorId(id_usuario);

		if (usuarioExistente != null) {
			usuarioRepository.delete(usuarioExistente);
			return "Usuário deletado.";
		} else {
			return "Usuário não deletado.";
		}
	}

	public Usuario buscarUsuario(Long id_usuario) {
		return buscarPorId(id_usuario);
	}

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.listarUsuarios();
	}

	private Usuario buscarPorId(Long id_usuario) {
		return usuarioRepository.buscarPorId(id_usuario);
	}
	/*private Usuario buscarPorLogin(String login) {
		return usuarioRepository.buscarPorLogin(login);
	}*/
}
