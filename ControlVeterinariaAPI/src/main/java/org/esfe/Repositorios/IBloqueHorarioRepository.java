package org.esfe.Repositorios;

import org.esfe.modelos.BloqueHorario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IBloqueHorarioRepository extends JpaRepository<BloqueHorario, Integer> {

    // trae solo activos
    List<BloqueHorario> findByActivoTrue();

    // trae solo inactivos
    List<BloqueHorario> findByActivoFalse();

    // trae según el valor
    List<BloqueHorario> findByActivo(boolean activo);
}
