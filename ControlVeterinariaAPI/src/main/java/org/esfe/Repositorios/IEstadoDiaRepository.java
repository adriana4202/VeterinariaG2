package org.esfe.Repositorios;

import org.esfe.modelos.EstadoDia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoDiaRepository extends JpaRepository<EstadoDia, Integer> {
}