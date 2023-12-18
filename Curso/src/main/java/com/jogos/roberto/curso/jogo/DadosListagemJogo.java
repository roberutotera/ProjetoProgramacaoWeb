package com.jogos.roberto.curso.jogo;

public record DadosListagemJogo(Long id, String nome, String ano, int quantidade, Plataforma plataforma) {
	
	public DadosListagemJogo(Jogo jogo) {
		this(jogo.getId(), jogo.getNome(), jogo.getAno(),jogo.getQuantidade(), jogo.getPlataforma());
	}

}
