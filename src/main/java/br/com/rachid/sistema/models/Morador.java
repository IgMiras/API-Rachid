package br.com.rachid.sistema.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String senha;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private TipoMorador tipo;

    @OneToMany(mappedBy = "morador", cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos;

    public enum Status {
        ATIVO, INATIVO
    }

    public enum TipoMorador {
        ADMIN, MORADOR
    }
}