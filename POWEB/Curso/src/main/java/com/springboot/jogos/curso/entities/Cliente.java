package com.springboot.jogos.curso.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Cliente")
@Entity(name = "clientes")
@Getter
@Setter
public class Cliente extends Usuario {

    @OneToMany
    @JoinColumn(name = "id_usuario")
    private List<Pedido> pedido;


	public Cliente(String cpf, String nome, String email, String telefone, String endereco) {
		super(cpf, nome, email, telefone, endereco);
		this.pedido = new ArrayList<>();
	}

	public Cliente() {
	}

	public void adicionarPedido(Pedido pedido) {
		this.pedido.add(pedido);
	}

	public void removerPedido(Pedido pedido) {
		this.pedido.remove(pedido);
	}

    public List<Pedido> getPedido() {
        return pedido;
    }
}
