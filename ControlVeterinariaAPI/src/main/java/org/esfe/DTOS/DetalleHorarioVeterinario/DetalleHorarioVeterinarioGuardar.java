package org.esfe.DTOS.DetalleHorarioVeterinario;

import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Setter
@Getter

public class DetalleHorarioVeterinarioGuardar implements Serializable {
    private Integer veterinarioId;
    private int diaId;
    private Byte bloqueHorarioId;
}
