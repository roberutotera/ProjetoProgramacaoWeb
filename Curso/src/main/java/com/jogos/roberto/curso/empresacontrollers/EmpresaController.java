package com.jogos.roberto.curso.empresacontrollers;

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

import com.jogos.roberto.curso.empresa.DadosAtualizarEmpresa;
import com.jogos.roberto.curso.empresa.DadosCadastroEmpresa;
import com.jogos.roberto.curso.empresa.DadosListagemEmpresa;
import com.jogos.roberto.curso.empresa.Empresa;
import com.jogos.roberto.curso.empresa.EmpresaRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroEmpresa dados){
		repository.save(new Empresa(dados));
	}
	
	@GetMapping
	public List<DadosListagemEmpresa> listar(){
		return repository.findAll().stream().map(DadosListagemEmpresa::new).toList();
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizarEmpresa dados) {
		var empresa = repository.getReferenceById(dados.id());
		empresa.atualizarInformacoes(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}

}