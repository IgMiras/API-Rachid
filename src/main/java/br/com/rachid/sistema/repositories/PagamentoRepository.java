package br.com.rachid.sistema.repositories;

import br.com.rachid.sistema.models.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    // Buscar pagamentos por status (se estão pagos ou não)
    List<Pagamento> findByEstaPago(Boolean estaPago);

    // Buscar pagamentos feitos por um morador específico
    List<Pagamento> findByMoradorId(Long moradorId);

    // Buscar pagamentos associados a uma despesa específica
    List<Pagamento> findByDespesaId(Long despesaId);

    // Buscar pagamentos realizados em uma data específica
    List<Pagamento> findByDataPagamento(Date dataPagamento);
}
