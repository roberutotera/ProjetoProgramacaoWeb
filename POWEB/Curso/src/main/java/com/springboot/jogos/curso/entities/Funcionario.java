package com.springboot.jogos.curso.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Funcionario")
@Entity(name = "funcionarios")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Funcionario extends Usuario {

    @NotBlank
    private String cargo;
    private float salario;
    private List<Pedido> vendas;

    public Funcionario(String loginUsuario, String senhaUsuario, String nome, String cpf, String endereco, String cargo, float salario, List<Pedido> vendas) {
        super(loginUsuario, senhaUsuario, nome, cpf, endereco);
        this.cargo = cargo;
        this.salario = salario;
        this.vendas = vendas;
    }

    public void adicionarVenda(Pedido pedido) {
        this.vendas.add(pedido);
    }
}
