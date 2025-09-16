package org.esfe.Repositorios;

import org.esfe.modelos.DetalleHorarioVeterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleHorarioVeterinarioRepository extends JpaRepository<DetalleHorarioVeterinario, Integer> {

}