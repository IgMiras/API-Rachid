package br.com.rachid.sistema.repositories;

import br.com.rachid.sistema.models.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    // Buscar despesas por tipo (FIXA ou VARIAVEL)
    List<Despesa> findByTipo(Despesa.Tipo tipo);

    // Buscar despesas criadas em uma determinada data
    List<Despesa> findByDataCriacao(Date dataCriacao);

    // Buscar despesas por data de vencimento
    List<Despesa> findByDataVencimento(Date dataVencimento);

    // Buscar despesas associadas a um morador específico
    List<Despesa> findByMoradoresId(Long moradorId);
}
