package com.jogos.roberto.curso.empresa;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarEmpresa(
		@NotNull
		Long id, 
		
		String nome_empresa) {

}
