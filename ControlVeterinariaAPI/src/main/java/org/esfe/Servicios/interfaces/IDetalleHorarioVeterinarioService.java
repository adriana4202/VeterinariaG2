package org.esfe.Servicios.interfaces;

import org.esfe.DTOS.DetalleHorarioVeterinario.DetalleHorarioVeterinarioGuardar;
import org.esfe.DTOS.DetalleHorarioVeterinario.DetalleHorarioVeterinarioSalida;

import java.util.List;

public interface IDetalleHorarioVeterinarioService {
    List<DetalleHorarioVeterinarioSalida> findAll();
    DetalleHorarioVeterinarioSalida findById(Integer id);
    DetalleHorarioVeterinarioSalida save(DetalleHorarioVeterinarioGuardar detalleDTO);
    DetalleHorarioVeterinarioSalida update(Integer id, DetalleHorarioVeterinarioGuardar detalleDTO);
    void deleteById(Integer id);
}