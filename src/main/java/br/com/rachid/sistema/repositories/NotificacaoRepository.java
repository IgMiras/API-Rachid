package br.com.rachid.sistema.repositories;

import br.com.rachid.sistema.models.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {

    // Buscar notificações por status (se foram lidas ou não)
    List<Notificacao> findByStatus(Boolean status);

    // Buscar notificações de um morador específico
    List<Notificacao> findByMoradorId(Long moradorId);

    // Buscar notificações criadas após uma determinada data
    List<Notificacao> findByDataAfter(Date data);

    // Buscar notificações por tipo (e.g., aviso, cobrança, etc.)
    List<Notificacao> findByTipo(String tipo);
}
