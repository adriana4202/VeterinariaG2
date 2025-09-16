package org.esfe.Servicios.interfaces;

import org.esfe.DTOS.BloqueHorario.BloqueHorarioGuardar;
import org.esfe.DTOS.BloqueHorario.BloqueHorarioModificar;
import org.esfe.DTOS.BloqueHorario.BloqueHorarioSalida;

import java.util.List;

public interface IBloqueHorarioService {

    List<BloqueHorarioSalida> listar();

    BloqueHorarioSalida buscarPorId(Integer id);

    BloqueHorarioSalida guardar(BloqueHorarioGuardar dto);

    BloqueHorarioSalida modificar(BloqueHorarioModificar dto);

    void eliminar(Integer id);
}
