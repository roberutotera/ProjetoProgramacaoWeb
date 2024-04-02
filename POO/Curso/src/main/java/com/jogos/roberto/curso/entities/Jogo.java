package com.jogos.roberto.curso.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



@Table(name = "Jogo")
@Entity(name = "jogos")
@Getter
@Setter
@EqualsAndHashCode(of = "id_jogo")

public class Jogo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
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
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
	
	@OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
    private List<Item> itens;

}