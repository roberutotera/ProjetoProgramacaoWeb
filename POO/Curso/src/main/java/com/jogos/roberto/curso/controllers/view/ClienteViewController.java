package com.jogos.roberto.curso.controllers.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jogos.roberto.curso.entities.Cliente;
import com.jogos.roberto.curso.services.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteViewController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/form")
    public String mostrarFormulario() {
        return "cliente-form";
    }

    @PostMapping("/adicionar")
    public String adicionarCliente(@RequestParam("login") String login,
                                   @RequestParam("senha") String senha,
                                   @RequestParam("nome") String nome,
                                   @RequestParam("cpf") String cpf,
                                   @RequestParam("endereco") String endereco) {
        clienteService.adicionarCliente(login, senha, nome, cpf, endereco);
        return "redirect:/clientes/listar";
    }

    @GetMapping("/listar")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarClientes());
        return "lista-clientes";
    }
}
