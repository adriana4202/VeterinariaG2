package org.esfe.Servicios.interfaces;

import org.esfe.DTOS.EstadoDia.EstadoDiaGuardar;
import org.esfe.DTOS.EstadoDia.EstadoDiaModificar;
import org.esfe.DTOS.EstadoDia.EstadoDiaSalida;
import java.util.List;

public interface IEstadoDiaService {
    List<EstadoDiaSalida> findAll();
    EstadoDiaSalida findById(int estadoDiaId);
    EstadoDiaSalida save(EstadoDiaGuardar estadoDiaDTO);
    EstadoDiaSalida update(int estadoDiaId, EstadoDiaModificar estadoDiaDTO);
    void deleteById(int estadoDiaId);
}