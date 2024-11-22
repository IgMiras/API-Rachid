package br.com.rachid.sistema.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Date dataCriacao;

    private Date dataVencimento;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private Double valorTotal;

    private String tipoDivisao;

    private String descricao;

    @OneToMany(mappedBy = "despesa", cascade = CascadeType.ALL)
    private List<ItemDespesa> itens;

    @OneToMany(mappedBy = "despesa", cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos;

    @ManyToMany
    @JoinTable(
            name = "despesa_morador",
            joinColumns = @JoinColumn(name = "despesa_id"),
            inverseJoinColumns = @JoinColumn(name = "morador_id")
    )
    private List<Morador> moradores;

    public enum Tipo {
        FIXA, VARIAVEL
    }
}
