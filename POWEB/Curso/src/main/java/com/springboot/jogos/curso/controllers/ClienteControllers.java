package com.springboot.jogos.curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jogos.curso.entities.Cliente;
import com.springboot.jogos.curso.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControllers {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/adicionar")
    public String adicionarCliente(@RequestBody Cliente cliente) {
        return clienteService.adicionarCliente(cliente);
    }

    @GetMapping("/buscar/{id}")
    public Cliente buscarCliente(@PathVariable Long id_usuario) {
        return clienteService.buscarCliente(id_usuario);
    }

    @GetMapping("/listar")
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @DeleteMapping("/deletar/{id_usuario}")
    public String deletarCliente(@PathVariable Long id_usuario) {
        return clienteService.deletarCliente(id_usuario);
    }
}
