package com.jogos.roberto.curso.empresa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "empresa")
@Entity(name = "empresas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Empresa {
	
	public Empresa(DadosCadastroEmpresa dados) {
		this.nome_empresa=dados.nome_empresa();
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome_empresa")
	private String nome_empresa;
	
	
	
	public void atualizarInformacoes(@Valid DadosAtualizarEmpresa dados) {
		if(dados.nome_empresa() != null) {
			this.nome_empresa=dados.nome_empresa();
		}
	}
}
