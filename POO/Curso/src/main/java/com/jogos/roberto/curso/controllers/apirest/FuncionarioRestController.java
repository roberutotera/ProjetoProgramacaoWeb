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

import com.jogos.roberto.curso.entities.Funcionario;
import com.jogos.roberto.curso.services.FuncionarioService;

@RestController
@RequestMapping("/api/v1/funcionarios")
public class FuncionarioRestController {
	
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/adicionar")
    public String adicionarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.adicionarFuncionario(funcionario.getLogin(), funcionario.getSenha(), 
        		funcionario.getNome(),funcionario.getCpf(),funcionario.getEndereco());
    }
    
    
    @PutMapping("/atualizar/{id_funcionario}")
    public String atualizarFuncionario(@PathVariable Long id_funcionario, @RequestBody Funcionario funcionario) {
    	return funcionarioService.atualizarFuncionario(id_funcionario, funcionario.getLogin(), funcionario.getSenha(), 
    			funcionario.getNome(), funcionario.getCpf(), funcionario.getEndereco());
    }

    @GetMapping("/buscar/{id_funcionario}")
    public Funcionario buscarFuncionario(@PathVariable Long id_funcionario) {
        return funcionarioService.buscarPorID(id_funcionario);
    }

    @GetMapping("/listar")
    public List<Funcionario> listarFuncionario() {
        return funcionarioService.listarFuncionario();
    }
   
    @DeleteMapping("/deletar/{id_funcionario}")
    public String deletarFuncionario(@PathVariable Long id_funcionario) {
        return funcionarioService.deletarFuncionario(id_funcionario);
    }
}