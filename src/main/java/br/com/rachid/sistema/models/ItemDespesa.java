package br.com.rachid.sistema.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ItemDespesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double valorUnitario;

    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "despesa_id")
    private Despesa despesa;

    public Double calcValorItem() {
        return valorUnitario * quantidade;
    }
}