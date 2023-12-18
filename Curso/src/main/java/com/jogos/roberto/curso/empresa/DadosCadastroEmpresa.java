package com.jogos.roberto.curso.empresa;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroEmpresa(
		
		@NotBlank
		String nome_empresa
		) {

}
