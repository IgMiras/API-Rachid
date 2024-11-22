package br.com.rachid.sistema.controllers;

import br.com.rachid.sistema.models.Pagamento;
import br.com.rachid.sistema.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<Pagamento> registrarPagamento(@RequestBody Pagamento pagamento) {
        return ResponseEntity.ok(pagamentoService.registrarPagamento(pagamento));
    }

    @GetMapping("/status/{estaPago}")
    public ResponseEntity<List<Pagamento>> listarPorStatus(@PathVariable Boolean estaPago) {
        return ResponseEntity.ok(pagamentoService.listarPorStatus(estaPago));
    }

    @GetMapping("/morador/{moradorId}")
    public ResponseEntity<List<Pagamento>> listarPorMorador(@PathVariable Long moradorId) {
        return ResponseEntity.ok(pagamentoService.listarPorMorador(moradorId));
    }
}
