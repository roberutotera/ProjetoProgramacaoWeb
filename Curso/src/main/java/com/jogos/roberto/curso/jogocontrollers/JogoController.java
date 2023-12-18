package com.jogos.roberto.curso.jogocontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jogos.roberto.curso.jogo.DadosCadastroJogos;
import com.jogos.roberto.curso.jogo.Jogo;
import com.jogos.roberto.curso.jogo.JogoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jogos")
public class JogoController {
	
	@Autowired
	private JogoRepository repository;
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid DadosCadastroJogos dados){
		repository.save(new Jogo(dados));
	}

}
