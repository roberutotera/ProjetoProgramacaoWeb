package com.jogos.roberto.curso.jogo;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroJogos(
		
		@NotBlank
		String nome,
		
		@NotBlank
		String ano,
		
		int quantidade,
		
		@Enumerated
		Plataforma plataforma,
		
		@NotNull
		Long id_empresa
		) {

}
