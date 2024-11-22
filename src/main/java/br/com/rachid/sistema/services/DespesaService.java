package br.com.rachid.sistema.services;

import br.com.rachid.sistema.models.Despesa;
import br.com.rachid.sistema.repositories.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    // Criar uma nova despesa
    public Despesa criarDespesa(Despesa despesa) {
        despesa.setDataCriacao(new Date());
        return despesaRepository.save(despesa);
    }

    // Listar todas as despesas
    public List<Despesa> listarTodas() {
        return despesaRepository.findAll();
    }

    // Buscar despesa por ID
    public Optional<Despesa> buscarPorId(Long id) {
        return despesaRepository.findById(id);
    }

    // Buscar despesas por tipo
    public List<Despesa> buscarPorTipo(Despesa.Tipo tipo) {
        return despesaRepository.findByTipo(tipo);
    }

    // Atualizar uma despesa
    public Despesa atualizarDespesa(Long id, Despesa despesaAtualizada) {
        return despesaRepository.findById(id).map(despesa -> {
            despesa.setNome(despesaAtualizada.getNome());
            despesa.setDataVencimento(despesaAtualizada.getDataVencimento());
            despesa.setValorTotal(despesaAtualizada.getValorTotal());
            despesa.setTipo(despesaAtualizada.getTipo());
            despesa.setDescricao(despesaAtualizada.getDescricao());
            return despesaRepository.save(despesa);
        }).orElseThrow(() -> new RuntimeException("Despesa não encontrada!"));
    }

    // Remover uma despesa
    public void removerDespesa(Long id) {
        despesaRepository.deleteById(id);
    }
}
