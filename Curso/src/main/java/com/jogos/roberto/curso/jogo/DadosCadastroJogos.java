package com.jogos.roberto.curso.jogo;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroJogos(
		
		@NotBlank
		String nome,
		@NotBlank
		String ano,
		int quantidade,
		@Enumerated
		Plataforma plataforma
		) {

}
