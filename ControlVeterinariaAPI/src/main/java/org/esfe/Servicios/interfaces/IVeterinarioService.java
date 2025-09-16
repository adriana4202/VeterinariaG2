package org.esfe.Servicios.interfaces;

import org.esfe.DTOS.veterinario.VeterinarioGuardar;
import org.esfe.DTOS.veterinario.VeterinarioModificar;
import org.esfe.DTOS.veterinario.VeterinarioSalida;

import java.util.List;

public interface IVeterinarioService {

    List<VeterinarioSalida> listar();

    List<VeterinarioSalida> listarActivos();

    VeterinarioSalida guardar(VeterinarioGuardar dto);

    VeterinarioSalida modificar(VeterinarioModificar dto);

    void inactivar(int id);

    void activar(int id);
}
