package br.com.rachid.sistema.controllers;

import br.com.rachid.sistema.models.Morador;
import br.com.rachid.sistema.services.MoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/moradores")
public class MoradorController {

    @Autowired
    private MoradorService moradorService;

    @PostMapping
    public ResponseEntity<Morador> cadastrarMorador(@RequestBody Morador morador) {
        return ResponseEntity.ok(moradorService.cadastrarMorador(morador));
    }

    @GetMapping
    public ResponseEntity<List<Morador>> listarTodos() {
        return ResponseEntity.ok(moradorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Morador> buscarPorId(@PathVariable Long id) {
        Optional<Morador> morador = moradorService.buscarPorId(id);
        return morador.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Morador> atualizarMorador(@PathVariable Long id, @RequestBody Morador moradorAtualizado) {
        return ResponseEntity.ok(moradorService.atualizarMorador(id, moradorAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerMorador(@PathVariable Long id) {
        moradorService.removerMorador(id);
        return ResponseEntity.noContent().build();
    }
}
