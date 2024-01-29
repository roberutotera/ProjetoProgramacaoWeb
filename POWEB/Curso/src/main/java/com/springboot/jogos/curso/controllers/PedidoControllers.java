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
@RequestMapping("/api/pedidos")
public class PedidoControllers {

    @PostMapping("")
	@ResponseBody
	public String adicionarPedido(Long id_pedido) {
		return "Pedido adicionado.";
	}

	@PutMapping("/{id_pedido}")
	@ResponseBody
	public String atualizarPedido(@PathVariable("id_pedido") Long id_pedido) {
		return "Pedido atualizado.";
	}

	@DeleteMapping("/{id_pedido}")
	@ResponseBody
	public String deletarPedido(@PathVariable("id_pedido") Long id_pedido) {
		return "Pedido deletado.";
	}

	@GetMapping("/{id_pedido}")
	@ResponseBody
	public String buscarPedido(@PathVariable("id_pedido") Long id_pedido) {
		return "Pedido retornado.";
	}

	@GetMapping("")
	@ResponseBody
	public String listarPedidos() {
		return "Pedidos listados.";
	}

	@PostMapping("/{id_pedido}/id_item")
	@ResponseBody
	public String adicionarItem(@PathVariable("id_pedido") Long id_pedido, Long id_item) {
		return "Item adicionado ao pedido.";
	}

	@DeleteMapping("/{id_pedido}/id_item")
	@ResponseBody
	public String deletarItem(@PathVariable("id_pedido") Long id_pedido, Long id_item) {
		return "Item deletado do pedido.";
	}

	@GetMapping("/{id}/id_item")
	@ResponseBody
	public String listarItens(@PathVariable("id_item") Long id_item) {
		return "Lista de itens do pedido.";
	}
}
