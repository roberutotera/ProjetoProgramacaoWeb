package com.springboot.jogos.curso.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jogos.curso.entities.Empresa;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaControllers {


    @PostMapping("/adicionar")
    public String adicionarEmpresa(@RequestBody Empresa empresa) {
        return "Empresa adicionada";
    }

    @GetMapping("/buscar/{id_empresa}")
    public String buscarEmpresa(@PathVariable Long id_empresa) {
        return "Empresa retornada";
    }

    @GetMapping("/listar")
    public String listarEmpresas(){
        return "Lista de empresas";
    }

    @DeleteMapping("/deletar/{id_empresa}")
    public String deletarEmpresa(){
        return "Empresa deletada";
    }
}
