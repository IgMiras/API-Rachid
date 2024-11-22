package br.com.rachid.sistema.services;

import br.com.rachid.sistema.models.Notificacao;
import br.com.rachid.sistema.repositories.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    // Criar uma notificação
    public Notificacao criarNotificacao(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    // Listar notificações de um morador específico
    public List<Notificacao> listarPorMorador(Long moradorId) {
        return notificacaoRepository.findByMoradorId(moradorId);
    }

    // Marcar uma notificação como lida
    public Notificacao marcarComoLida(Long id) {
        return notificacaoRepository.findById(id).map(notificacao -> {
            notificacao.setStatus(true);
            return notificacaoRepository.save(notificacao);
        }).orElseThrow(() -> new RuntimeException("Notificação não encontrada!"));
    }
}
