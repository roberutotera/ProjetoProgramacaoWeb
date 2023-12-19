package com.jogos.roberto.curso.jogocontrollers;

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

import com.jogos.roberto.curso.empresa.EmpresaRepository;
import com.jogos.roberto.curso.jogo.DadosAtualizarJogos;
import com.jogos.roberto.curso.jogo.DadosCadastroJogos;
import com.jogos.roberto.curso.jogo.DadosListagemJogo;
import com.jogos.roberto.curso.jogo.Jogo;
import com.jogos.roberto.curso.jogo.JogoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/jogos")
public class JogoController {
	
	@Autowired
	private JogoRepository repository;
	@Autowired
	private EmpresaRepository empresaRepository;
	
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroJogos dados){
		var empresa = empresaRepository.getReferenceById(dados.id_empresa());
		repository.save(new Jogo(dados, empresa));
	}
	
	@GetMapping
	public List<DadosListagemJogo> listar(){
		return repository.findAll().stream().map(DadosListagemJogo::new).toList();
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizarJogos dados) {
		var jogo = repository.getReferenceById(dados.id());
		jogo.atualizarInformacoes(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
