
package org.esfe.Repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.esfe.modelos.Especialidad;

@Repository
public interface IEspecialidadRepository extends JpaRepository<Especialidad, Integer> {

    // trae solo activos
    List<Especialidad> findByActivoTrue();

    // trae solo inactivos
    List<Especialidad> findByActivoFalse();

    // trae según el valor que se pase
    List<Especialidad> findByActivo(boolean activo);
}

