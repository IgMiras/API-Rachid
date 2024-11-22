package br.com.rachid.sistema.controllers;

import br.com.rachid.sistema.models.Despesa;
import br.com.rachid.sistema.services.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @PostMapping
    public ResponseEntity<Despesa> criarDespesa(@RequestBody Despesa despesa) {
        return ResponseEntity.ok(despesaService.criarDespesa(despesa));
    }

    @GetMapping
    public ResponseEntity<List<Despesa>> listarTodas() {
        return ResponseEntity.ok(despesaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Despesa> buscarPorId(@PathVariable Long id) {
        Optional<Despesa> despesa = despesaService.buscarPorId(id);
        return despesa.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Despesa> atualizarDespesa(@PathVariable Long id, @RequestBody Despesa despesaAtualizada) {
        return ResponseEntity.ok(despesaService.atualizarDespesa(id, despesaAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerDespesa(@PathVariable Long id) {
        despesaService.removerDespesa(id);
        return ResponseEntity.noContent().build();
    }
}
