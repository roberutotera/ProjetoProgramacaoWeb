package com.jogos.roberto.curso.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Empresa")
@Entity(name = "empresas")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id_empresa")

public class Empresa {

	public Empresa() {
		
	}
	
	public Empresa(String nome_empresa) {
		this.nome_empresa = nome_empresa;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id_empresa;
	@NotBlank
	public String nome_empresa;
	
}
