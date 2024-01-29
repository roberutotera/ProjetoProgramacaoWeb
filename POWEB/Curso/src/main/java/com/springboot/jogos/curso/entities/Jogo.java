package com.springboot.jogos.curso.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Jogo")
@Entity(name = "jogos")
@Getter
@Setter
@EqualsAndHashCode(of = "id_jogo")

public class Jogo {
	
	public Jogo(String nome, String ano, int quantidade, Plataforma plataforma, Empresa empresa, float preco) {
		this.nome=nome;
		this.empresa = empresa;
		this.ano=ano;
		this.quantidade=quantidade;
		this.plataforma=plataforma;
		this.preco=preco;
	}
	
	public Jogo() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_jogo;
	private String nome;
	private String ano;
	private int quantidade;
	private float preco;
	
	@Enumerated(EnumType.STRING)
	private Plataforma plataforma;
	
	@ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

}
