package br.com.rachid.sistema.services;

import br.com.rachid.sistema.models.Pagamento;
import br.com.rachid.sistema.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    // Registrar um pagamento
    public Pagamento registrarPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    // Buscar pagamentos por status
    public List<Pagamento> listarPorStatus(Boolean estaPago) {
        return pagamentoRepository.findByEstaPago(estaPago);
    }

    // Listar pagamentos de um morador específico
    public List<Pagamento> listarPorMorador(Long moradorId) {
        return pagamentoRepository.findByMoradorId(moradorId);
    }
}
