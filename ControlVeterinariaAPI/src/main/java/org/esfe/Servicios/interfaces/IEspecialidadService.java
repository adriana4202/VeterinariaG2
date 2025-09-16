package org.esfe.Servicios.interfaces;

import org.esfe.DTOS.Especialidad.EspecialidadGuardar;
import org.esfe.DTOS.Especialidad.EspecialidadModificar;
import org.esfe.DTOS.Especialidad.EspecialidadSalida;

import java.util.List;

public interface IEspecialidadService {

    List<EspecialidadSalida> listar();

    EspecialidadSalida buscarPorId(Integer id);

    EspecialidadSalida guardar(EspecialidadGuardar dto);

    EspecialidadSalida modificar(EspecialidadModificar dto);

    void eliminar(Integer id);
}

