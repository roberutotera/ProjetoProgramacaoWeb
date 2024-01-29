package com.springboot.jogos.curso.entities;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Pedido")
@Entity(name = "pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido;

    private float valorTotal;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_pedido")
    private Date dataPedido;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_entrega")
    private Date dataEntrega;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Cliente cliente;

    private boolean finalizado;

    public void finalizar() {
        this.finalizado = true;
        this.dataPedido = new Date(System.currentTimeMillis());
    }
    
}
