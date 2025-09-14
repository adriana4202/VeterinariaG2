package org.esfe.Repositorios;

import org.esfe.modelos.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVeterinarioRepository extends JpaRepository<Veterinario, Short> {
    List<Veterinario> findByEstadoId(Byte estadoId);
}
