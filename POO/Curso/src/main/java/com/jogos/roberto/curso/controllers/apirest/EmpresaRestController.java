package com.jogos.roberto.curso.controllers.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jogos.roberto.curso.entities.Empresa;
import com.jogos.roberto.curso.services.EmpresaService;


@RestController
@RequestMapping(path = "/api/v1/empresa")
public class EmpresaRestController {
	
	@Autowired
	private EmpresaService empresaService;

    @PostMapping("/adicionar")
    public String adicionarEmpresa(@RequestBody Empresa empresa) {
        return empresaService.adicionarEmpresa(empresa.getNome_empresa());
    }

    @GetMapping("/buscar/{id_empresa}")
    public Empresa buscarEmpresa(@PathVariable Long id_empresa) {
        return empresaService.buscarEmpresa(id_empresa);
    }

    @GetMapping("/listar")
    public List<Empresa> listarEmpresas() {
        return empresaService.listarEmpresas();
    }

    @DeleteMapping("/deletar/{id_empresa}")
    public String deletarEmpresa(@PathVariable Long id_empresa) {
        return empresaService.deletarEmpresa(id_empresa);
    }
}


