package br.com.rachid.sistema.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    private String tipo;

    private Boolean status;

    private Date data;

    @ManyToOne
    @JoinColumn(name = "morador_id")
    private Morador morador;
}