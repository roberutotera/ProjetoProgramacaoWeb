package com.jogos.roberto.curso.jogocontrollers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jogos.roberto.curso.jogo.DadosCadastroJogos;

@RestController
@RequestMapping("/jogos")
public class JogoController {
	
	@PostMapping
	public void cadastrar(@RequestBody DadosCadastroJogos dados){
		System.out.println(dados);
	}

}
