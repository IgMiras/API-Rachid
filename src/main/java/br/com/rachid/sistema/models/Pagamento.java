package br.com.rachid.sistema.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorPagamento;

    private Date dataPagamento;

    private Boolean estaPago;

    @Lob
    private byte[] comprovante;

    @ManyToOne
    @JoinColumn(name = "morador_id")
    private Morador morador;

    @ManyToOne
    @JoinColumn(name = "despesa_id")
    private Despesa despesa;
}