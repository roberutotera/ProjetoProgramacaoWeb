package com.jogos.roberto.curso.jogo;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarJogos(
		@NotNull
		Long id, 
		
		int quantidade, 
		
		Plataforma plataforma) {

}
