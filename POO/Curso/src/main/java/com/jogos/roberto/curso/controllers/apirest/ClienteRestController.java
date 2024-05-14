package com.jogos.roberto.curso.controllers.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jogos.roberto.curso.entities.Cliente;
import com.jogos.roberto.curso.services.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteRestController {
	
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/adicionar")
    public String adicionarCliente(@RequestBody Cliente cliente) {
        return clienteService.adicionarCliente(cliente.getLogin(), cliente.getSenha(), 
        		cliente.getNome(),cliente.getCpf(),cliente.getEndereco());
    }
    
    @PutMapping("/atualizar/{id_cliente}")
    public String atualizarCliente(@PathVariable Long id_cliente, @RequestBody Cliente cliente) {
    	return clienteService.atualizarCliente(id_cliente, cliente.getLogin(), cliente.getSenha(), 
    			cliente.getNome(), cliente.getCpf(), cliente.getEndereco());
    }

    @GetMapping("/buscar/{id_cliente}")
    public Cliente buscarCliente(@PathVariable Long id_cliente) {
        return clienteService.buscarPorID(id_cliente);
    }

    @GetMapping("/listar")
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @DeleteMapping("/deletar/{id_cliente}")
    public String deletarCliente(@PathVariable Long id_cliente) {
        return clienteService.deletarCliente(id_cliente);
    }
}