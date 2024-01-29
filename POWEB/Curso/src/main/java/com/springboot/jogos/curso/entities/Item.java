package com.springboot.jogos.curso.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Item")
@Entity(name = "itens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_item;

    @ManyToOne
    private Jogo jogo;

    private int quantidade;

    @Positive(message = "Tem que ser maior que 0")
    @Column(name = "preco_unitario")
    private float precoUnitario;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    
    public Item(Jogo jogo, int quantidade, float precoUnitario) {
        this.jogo = jogo;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }
}
