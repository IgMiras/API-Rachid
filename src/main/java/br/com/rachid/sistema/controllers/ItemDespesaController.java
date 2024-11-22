package br.com.rachid.sistema.controllers;

import br.com.rachid.sistema.models.ItemDespesa;
import br.com.rachid.sistema.services.ItemDespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens-despesa")
public class ItemDespesaController {

    @Autowired
    private ItemDespesaService itemDespesaService;

    @PostMapping
    public ResponseEntity<ItemDespesa> adicionarItem(@RequestBody ItemDespesa itemDespesa) {
        return ResponseEntity.ok(itemDespesaService.adicionarItem(itemDespesa));
    }

    @GetMapping("/despesa/{despesaId}")
    public ResponseEntity<List<ItemDespesa>> listarPorDespesa(@PathVariable Long despesaId) {
        return ResponseEntity.ok(itemDespesaService.listarPorDespesa(despesaId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerItem(@PathVariable Long id) {
        itemDespesaService.removerItem(id);
        return ResponseEntity.noContent().build();
    }
}
