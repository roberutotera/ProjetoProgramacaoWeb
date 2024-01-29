package com.springboot.jogos.curso.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Usuario")
@Entity(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id_usuario")

public abstract class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;

	@NotBlank(message = "Login não pode ser em branco ou nulo")
	@Size(min = 3, max = 30, message = "Login deve ter entre 3 e 30 caracteres")
	private String loginUsuario;

	@NotBlank(message = "Senha não pode ser em branco ou nula")
	@Size(min = 6, max = 60, message = "Senha deve ter entre 6 e 60 caracteres")
	private String senhaUsuario;

	@NotBlank
	private String nome;

	@NotBlank
	private String cpf;

	@NotBlank
	private String endereco;
	
	@Nullable
	@ElementCollection
	@Size(min = 1, max = 2, message = "Tem que ter entre 1 e 2 telefones")
	@Column(length = 11)
	private List<@Pattern(regexp = "[0-9]{9,11}", message = "Deve seguir o padrão do Telefone") String> telefones = new ArrayList<>();


	public Usuario(String loginUsuario, String senhaUsuario, String cpf, String nome, String telefone, String endereco){
		this.loginUsuario = loginUsuario;
		this.senhaUsuario = senhaUsuario;
		this.cpf = cpf;
		this.nome = nome;
		this.telefones.add(telefone);
		this.endereco = endereco;
	}

	public Usuario(String loginUsuario, String senhaUsuario, String nome, String cpf, String endereco) {
		
	}

    public void login(String loginUsuario, String senha) {
    }


    public void logout() {
	
	}
}