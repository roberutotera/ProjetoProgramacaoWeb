package com.springboot.jogos.curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jogos.curso.entities.Item;
import com.springboot.jogos.curso.entities.Pedido;
import com.springboot.jogos.curso.services.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoControllers {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    public void PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/buscar/{id}")
    public Pedido buscarPedido(@PathVariable Long id) {
        return pedidoService.buscarPorId(id);
    }

    @PostMapping("/adicionar/{id_usuario}")
    public String adicionarPedido(@PathVariable Long id_usuario) {
        return pedidoService.adicionarPedido(id_usuario);
    }

    @PutMapping("/atualizar/{id_pedido}/{id_usuario}")
    public String atualizarPedido(@PathVariable Long id_pedido, @PathVariable Long id_usuario,
                                @RequestParam float valorTotal, @RequestParam java.sql.Date dataPedido,
                                @RequestParam java.sql.Date dataEntrega) {
        // Fazer a conversão de String para java.sql.Date, se necessário
        return pedidoService.atualizarPedido(id_pedido, id_usuario, valorTotal, dataPedido, dataEntrega);
    }

    @DeleteMapping("/deletar/{id_pedido}")
    public String deletarPedido(@PathVariable Long id_pedido) {
        return pedidoService.deletarPedido(id_pedido);
    }

    @GetMapping("/listar")
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @PostMapping("/adicionarItem/{id_pedido}")
    public String adicionarItemAoPedido(@PathVariable Long id_pedido, @RequestBody Item item) {
        return pedidoService.adicionarItemAoPedido(id_pedido, item);
    }

    @DeleteMapping("/deletarItem/{id_pedido}/{id_item}")
    public String deletarItemDoPedido(@PathVariable Long id_pedido, @PathVariable Long id_item) {
        return pedidoService.deletarItemDoPedido(id_pedido, id_item);
    }
}
