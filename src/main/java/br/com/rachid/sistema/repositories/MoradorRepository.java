package br.com.rachid.sistema.repositories;

import br.com.rachid.sistema.models.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, Long> {

    // Buscar um morador por e-mail (usado em autenticação e recuperação de senha)
    Optional<Morador> findByEmail(String email);

    // Buscar moradores por status (ativo ou inativo)
    List<Morador> findByStatus(Morador.Status status);

    // Buscar moradores por tipo (ADMIN ou MORADOR)
    List<Morador> findByTipo(Morador.TipoMorador tipo);
}
