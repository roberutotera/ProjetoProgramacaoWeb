package com.springboot.jogos.curso.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControllers {

    @PostMapping("")
	@ResponseBody
	public String adicionarUsuario(String loginUsuario, String senhaUsuario) {
		return "Usuario adicionado.";
	}

	@PutMapping("/{id_usuario}")
	@ResponseBody
	public String atualizarUsuario(@PathVariable("id_usuario") Long id_usuario, String senhaUsuario) {
		return "Usuario atualizado.";
	}

	@DeleteMapping("/{id_usuario}")
	@ResponseBody
	public String deletarUsuario(@PathVariable("id_usuario") Long id_usuario) {
		return "Usuario deletado.";
	}

	@GetMapping("/{id_usuario}")
	@ResponseBody
	public String buscarUsuario(@PathVariable("id_usuario") Long id_usuario) {
		return "Usuario retornado.";
	}

	@GetMapping("")
	@ResponseBody
	public String listarUsuarios() {
		return "Lista de usuarios.";
	}
}
