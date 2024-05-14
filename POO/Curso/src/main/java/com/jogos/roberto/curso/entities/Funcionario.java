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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Funcionario")
@Entity(name = "funcionarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_funcionario")

public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_funcionario;
	
	@NotBlank
	private String login;
	@NotBlank
	private String senha;
	@NotBlank
	private String nome;
	@NotBlank
	private String cpf;
	@NotBlank
	private String endereco;
	
}
