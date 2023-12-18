package com.jogos.roberto.curso.empresacontrollers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jogos.roberto.curso.empresa.DadosCadastroEmpresa;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
	
	@PostMapping
	public void cadastrar(@RequestBody DadosCadastroEmpresa dados){
		System.out.println(dados);
	}

}