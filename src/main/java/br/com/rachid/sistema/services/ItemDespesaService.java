package br.com.rachid.sistema.services;

import br.com.rachid.sistema.models.ItemDespesa;
import br.com.rachid.sistema.repositories.ItemDespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDespesaService {

    @Autowired
    private ItemDespesaRepository itemDespesaRepository;

    // Criar ou adicionar um item de despesa
    public ItemDespesa adicionarItem(ItemDespesa itemDespesa) {
        return itemDespesaRepository.save(itemDespesa);
    }

    // Listar todos os itens de uma despesa específica
    public List<ItemDespesa> listarPorDespesa(Long despesaId) {
        return itemDespesaRepository.findByDespesaId(despesaId);
    }

    // Remover um item de despesa
    public void removerItem(Long id) {
        itemDespesaRepository.deleteById(id);
    }
}
