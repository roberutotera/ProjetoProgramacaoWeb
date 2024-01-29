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
@RequestMapping("/api/clientes")
public class ClienteControllers {

    @PostMapping("")
	@ResponseBody
	public String adicionarCliente(String nome, String email, String telefone, String endereco) {
		return "Cliente adicionado: " + nome;
	}

	@PutMapping("/{id_usuario}")
	@ResponseBody
	public String atualizarCliente(@PathVariable("id_usuario") Long id_usuario, String nome, String email, String senha) {
		return "Cliente atualizado.";
	}

	@DeleteMapping("/{id_usuario}")
	@ResponseBody
	public String deletarCliente(@PathVariable("id_usuario") Long id_usuario) {
		return "Cliente deletado.";
	}

	@GetMapping("/{id_usuario}")
	@ResponseBody
	public String buscarCliente(@PathVariable("id_usuario") Long id_usuario) {
		return "Cliente retornado.";
	}

	@GetMapping("")
	@ResponseBody
	public String listarClientes() {
		return "Clientes listados.";
	}

	@PostMapping("/{id_usuario}/telefone")
	@ResponseBody
	public String adicionarTelefone(@PathVariable("id_usuario") Long id_usuario, String telefone) {
		return "Telefone adicionado ao cliente.";
	}

	@DeleteMapping("/{id_usuario}/telefone")
	@ResponseBody
	public String deletarTelefone(@PathVariable("id_usuario") Long id_usuario, String telefone) {
		return "Telefone deletado do cliente.";
	}

}


