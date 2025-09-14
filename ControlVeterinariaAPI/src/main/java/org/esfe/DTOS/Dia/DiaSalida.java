package org.esfe.DTOS.Dia;

import lombok.Getter;
import lombok.Setter;
import org.esfe.DTOS.EstadoDia.EstadoDiaSalida;

@Getter
@Setter
public class DiaSalida {
    private int diaId;
    private String nombre;
    private EstadoDiaSalida estadoDia;
}