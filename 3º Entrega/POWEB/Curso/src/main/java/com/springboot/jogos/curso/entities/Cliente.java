package com.springboot.jogos.curso.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Cliente")
@Entity(name = "clientes")
@Getter
@Setter
public class Cliente extends Usuario {


	public Cliente(String cpf, String nome, String email, String telefone, String endereco) {
		super(cpf, nome, email, telefone, endereco);
	}

	public Cliente() {
	}

}
