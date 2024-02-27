package com.springboot.jogos.curso.controllers;

import com.springboot.jogos.curso.entities.Funcionario;
import com.springboot.jogos.curso.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioControllers {

    private FuncionarioService funcionarioService;

    @Autowired
    public void FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping("/adicionar")
    public String adicionarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.adicionarFuncionario(funcionario);
    }

    @GetMapping("/buscar/{id_usuario}")
    public Funcionario buscarFuncionario(@PathVariable Long id_usuario) {
        return funcionarioService.buscarFuncionario(id_usuario);
    }

    @GetMapping("/listar")
    public List<Funcionario> listarFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }

    @DeleteMapping("/deletar/{id_usuario}")
    public String deletarFuncionario(@PathVariable Long id_usuario) {
        return funcionarioService.deletarFuncionario(id_usuario);
    }
}
