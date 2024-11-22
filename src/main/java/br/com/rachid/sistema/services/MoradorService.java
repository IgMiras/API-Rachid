package br.com.rachid.sistema.services;

import br.com.rachid.sistema.models.Morador;
import br.com.rachid.sistema.repositories.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoradorService {

    @Autowired
    private MoradorRepository moradorRepository;

    // Cadastrar um novo morador
    public Morador cadastrarMorador(Morador morador) {
        return moradorRepository.save(morador);
    }

    // Buscar todos os moradores
    public List<Morador> listarTodos() {
        return moradorRepository.findAll();
    }

    // Buscar morador por ID
    public Optional<Morador> buscarPorId(Long id) {
        return moradorRepository.findById(id);
    }

    // Buscar morador por e-mail
    public Optional<Morador> buscarPorEmail(String email) {
        return moradorRepository.findByEmail(email);
    }

    // Atualizar informações de um morador
    public Morador atualizarMorador(Long id, Morador moradorAtualizado) {
        return moradorRepository.findById(id).map(morador -> {
            morador.setNome(moradorAtualizado.getNome());
            morador.setEmail(moradorAtualizado.getEmail());
            morador.setTelefone(moradorAtualizado.getTelefone());
            morador.setStatus(moradorAtualizado.getStatus());
            morador.setTipo(moradorAtualizado.getTipo());
            return moradorRepository.save(morador);
        }).orElseThrow(() -> new RuntimeException("Morador não encontrado!"));
    }

    // Remover um morador
    public void removerMorador(Long id) {
        moradorRepository.deleteById(id);
    }
}
