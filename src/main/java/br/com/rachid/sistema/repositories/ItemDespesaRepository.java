package br.com.rachid.sistema.repositories;

import br.com.rachid.sistema.models.ItemDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDespesaRepository extends JpaRepository<ItemDespesa, Long> {

    // Buscar itens de despesa por uma despesa específica
    List<ItemDespesa> findByDespesaId(Long despesaId);

    // Buscar itens de despesa com valor unitário maior que um valor específico
    List<ItemDespesa> findByValorUnitarioGreaterThan(Double valor);
}
