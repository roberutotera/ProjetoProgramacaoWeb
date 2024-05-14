package com.jogos.roberto.curso.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Cliente")
@Entity(name = "clientes")
@EqualsAndHashCode(of = "id_cliente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

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

    @OneToMany
    @JoinColumn(name = "id_cliente")
    @JsonIgnore
    private List<Pedido> pedido;

    public void adicionarPedido(Pedido pedido) {
        this.pedido.add(pedido);
    }

    public void removerPedido(Pedido pedido) {
        this.pedido.remove(pedido);
    }
}
