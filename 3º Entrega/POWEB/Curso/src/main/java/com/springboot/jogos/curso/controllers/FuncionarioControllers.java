package com.springboot.jogos.curso.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioControllers {

    @PostMapping("")
	@ResponseBody
	public String adicionarFuncionario(String nome, String email, String telefone, String endereco, String cargo,
			float salario) {
		return "Funcionario adicionado: " + nome;
	}

	@PutMapping("/{id_usuario}")
	@ResponseBody
	public String atualizarFuncionario(@PathVariable("id_usuario") Long loginUsuario, String nome, String email, String senhaUsuario,
			String cargo, float salario) {
		return "Funcionario atualizado.";
	}

	@DeleteMapping("/{id_usuario}")
	@ResponseBody
	public String deletarFuncionario(@PathVariable("id_usuario") Long id_usuario) {
		return "Funcionario deletado.";
	}

	@GetMapping("/{id_usuario}")
	@ResponseBody
	public String buscarFuncionario(@PathVariable("id_usuario") Long id_usuario) {
		return "Funcionario retornado.";
	}

	@GetMapping("")
	@ResponseBody
	public String listarFuncionarios() {
		return "Funcionarios listados.";
	}

	@PostMapping("/{id_usuario}/id_venda")
	@ResponseBody
	public String adicionarVenda(@PathVariable("id_usuario") Long id_usuario, Long id_vendas) {
		return "Venda adicionada ao funcionario.";
	}

	@DeleteMapping("/{id_usuario}/id_venda")
	@ResponseBody
	public String deletarVenda(@PathVariable("id_usuario") Long id_usuario, Long id_vendas) {
		return "Venda deletada do funcionario.";
	}

	@GetMapping("/{id_usuario}/id_vendas")
	@ResponseBody
	public String listarVendas(@PathVariable("id_vendas") Long id_vendas) {
		return "Lista de vendas do funcionaio.";
	}
}
