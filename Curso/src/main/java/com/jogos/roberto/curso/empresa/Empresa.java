package com.jogos.roberto.curso.empresa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome_empresa;

}
