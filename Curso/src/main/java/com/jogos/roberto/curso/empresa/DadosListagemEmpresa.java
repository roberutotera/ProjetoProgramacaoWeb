package com.jogos.roberto.curso.empresa;

public record DadosListagemEmpresa(Long id,String nome_empresa) {
	
	public DadosListagemEmpresa (Empresa empresa) {
		this(empresa.getId(), empresa.getNome_empresa());
	}

}
