package com.jogos.roberto.curso.controllers.apirest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jogos.roberto.curso.entities.Pedido;
import com.jogos.roberto.curso.services.PedidoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoRestController {

	@Autowired
	private PedidoService pedidoService;

	@PostMapping("/adicionar")
	@ResponseBody
	@Operation(summary = "Adicionar um pedido em específico")
	public ResponseEntity<String> adicionarPedido(@RequestBody Long id_cliente, @RequestBody String formaPagamento)
			throws Exception {
		try {
			Pedido resultado = pedidoService.adicionarPedido(id_cliente, formaPagamento);
			return ResponseEntity.ok(resultado != null ? "Pedido adicionado. Id: " + resultado.getId_pedido()
					: "Não foi possível criar um pedido.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar pedido.");
		}
	}

	@PutMapping("/{id_pedido}")
	@ResponseBody
	@Operation(summary = "Atualizar um pedido em específico")
	public ResponseEntity<String> atualizarPedido(@PathVariable Long id_pedido, @RequestParam Long id_cliente,
			@RequestParam float valorTotal,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataPedido,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataEntrega,
			@RequestParam String formaPagamento, boolean status) throws Exception {

		try {
			String mensagem = pedidoService.atualizarPedido(id_pedido, id_cliente, valorTotal, dataPedido, dataEntrega,
					formaPagamento, status);
			return ResponseEntity.ok(mensagem);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar pedido.");
		}
	}

	@DeleteMapping("/{id_pedido}")
	@ResponseBody
	@Operation(summary = "Deletar um pedido em específico")
	public ResponseEntity<String> deletarPedido(@PathVariable Long id_pedido) throws Exception {
		try {
			String mensagem = pedidoService.deletarPedido(id_pedido);
			return ResponseEntity.ok(mensagem);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar pedido.");
		}
	}

	@GetMapping("/{id_pedido}")
	@ResponseBody
	@Operation(summary = "Retornar um pedido em específico")
	public ResponseEntity<Pedido> buscarPedido(@PathVariable Long id_pedido) throws Exception {
		try {
			Pedido pedido = pedidoService.buscarPorId(id_pedido);
			return ResponseEntity.ok(pedido);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PatchMapping("/{id_pedido}")
	@ResponseBody
	@Operation(summary = "Finalizar um pedido em específico")
	public ResponseEntity<String> finalizarPedido(@PathVariable Long id_pedido) throws Exception {
		try {
			String mensagem = pedidoService.finalizarPedido(id_pedido);
			return ResponseEntity.ok(mensagem);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao finalizar pedido.");
		}
	}

	@GetMapping
	@ResponseBody
	@Operation(summary = "Listar todos os pedidos")
	public ResponseEntity<List<Pedido>> listarPedidos() throws Exception {
		List<Pedido> pedidos = pedidoService.listarPedidos();
		return ResponseEntity.ok(pedidos);
	}

	@PostMapping("/itemaocliente")
	@ResponseBody
	@Operation(summary = "Adicionar um item ao pedido em um cliente em específico")
	public ResponseEntity<String> adicionarItem(@RequestBody Long id_pedido, @RequestBody Long id_jogo, @RequestBody int quantidade) throws Exception {
	    try {
	        String mensagem = pedidoService.adicionarItemAoPedido(id_pedido, id_jogo, quantidade);
	        return ResponseEntity.ok(mensagem);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar item ao pedido.");
	    }
	}

	
}
