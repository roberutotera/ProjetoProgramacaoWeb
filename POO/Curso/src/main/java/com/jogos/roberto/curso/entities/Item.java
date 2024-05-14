package com.jogos.roberto.curso.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_item;

	@ManyToOne
	@JoinColumn(name = "id_jogo") // Nome da coluna na tabela do banco de dados
	private Jogo jogo;


    @PositiveOrZero(message = "A quantidade deve ser maior ou igual a 0")
	private int quantidade;

    
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	@JsonBackReference
	private Pedido pedido;
	
	

	public Item(Jogo jogo, int quantidade) {
		this.jogo = jogo;
		this.quantidade = quantidade;
	}

	public Item() {
	}

	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Long getId_item() {
		return id_item;
	}

	public void setId_item(Long id_item) {
		this.id_item = id_item;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


}