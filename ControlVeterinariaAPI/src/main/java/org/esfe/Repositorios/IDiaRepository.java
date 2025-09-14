package org.esfe.Repositorios;

import org.esfe.modelos.Dia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiaRepository extends JpaRepository<Dia, Integer> {
}