package com.jogos.roberto.curso.empresacontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jogos.roberto.curso.empresa.DadosCadastroEmpresa;
import com.jogos.roberto.curso.empresa.Empresa;
import com.jogos.roberto.curso.empresa.EmpresaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository repository;
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid DadosCadastroEmpresa dados){
		repository.save(new Empresa(dados));
	}

}