package com.jogos.roberto.curso.jogo;

import com.jogos.roberto.curso.empresa.Empresa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "jogo")
@Entity(name = "jogos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of ="id")
public class Jogo {
	
	public Jogo(DadosCadastroJogos dados, @NotNull Empresa empresa) {
		this.nome=dados.nome();
		this.ano=dados.ano();
		this.quantidade=dados.quantidade();
		this.plataforma=dados.plataforma();
		this.empresa=empresa;
	}

	@Column(name = "id")
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	@Column(name = "ano")
	private String ano;
	@Column(name = "quantidade")
	private int quantidade;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private @NotNull Empresa empresa;
	
	
	@Enumerated(EnumType.STRING)
	private Plataforma plataforma;

	public void atualizarInformacoes(@Valid DadosAtualizarJogos dados) {
		if(dados.plataforma() != null && dados.quantidade() >=0) {
			this.plataforma=dados.plataforma();
			this.quantidade=dados.quantidade();
		}
		
	}
}
