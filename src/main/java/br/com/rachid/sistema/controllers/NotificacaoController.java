package br.com.rachid.sistema.controllers;

import br.com.rachid.sistema.models.Notificacao;
import br.com.rachid.sistema.services.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @PostMapping
    public ResponseEntity<Notificacao> criarNotificacao(@RequestBody Notificacao notificacao) {
        return ResponseEntity.ok(notificacaoService.criarNotificacao(notificacao));
    }

    @GetMapping("/morador/{moradorId}")
    public ResponseEntity<List<Notificacao>> listarPorMorador(@PathVariable Long moradorId) {
        return ResponseEntity.ok(notificacaoService.listarPorMorador(moradorId));
    }

    @PutMapping("/{id}/marcar-como-lida")
    public ResponseEntity<Notificacao> marcarComoLida(@PathVariable Long id) {
        return ResponseEntity.ok(notificacaoService.marcarComoLida(id));
    }
}
