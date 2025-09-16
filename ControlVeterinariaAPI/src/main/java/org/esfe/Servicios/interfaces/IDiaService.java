package org.esfe.Servicios.interfaces;

import org.esfe.DTOS.Dia.DiaGuardar;
import org.esfe.DTOS.Dia.DiaModificar;
import org.esfe.DTOS.Dia.DiaSalida;

import java.util.List;

public interface IDiaService {
    List<DiaSalida> findAll();
    DiaSalida findById(int diaId);
    DiaSalida save(DiaGuardar diaDTO);
    DiaSalida update(int diaId, DiaModificar diaDTO);
    void deleteById(int diaId);
}