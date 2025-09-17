package org.esfe.Servicios.interfaces;

import org.esfe.DTOS.Especialidad.EspecialidadGuardar;
import org.esfe.DTOS.Especialidad.EspecialidadModificar;
import org.esfe.DTOS.Especialidad.EspecialidadSalida;
import org.esfe.modelos.Especialidad;
import java.util.List;

public interface IEspecialidadService {

    List<EspecialidadSalida> listar();

    EspecialidadSalida buscarPorId(Integer id);

    EspecialidadSalida guardar(EspecialidadGuardar dto);

    EspecialidadSalida modificar(EspecialidadModificar dto);

    void eliminar(Integer id);

    // 👇 nuevo método para activación lógica
    void activar(Integer id);

    List<EspecialidadSalida> listarInactivos();

}

