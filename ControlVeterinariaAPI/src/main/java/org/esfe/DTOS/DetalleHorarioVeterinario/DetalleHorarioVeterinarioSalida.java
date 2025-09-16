package org.esfe.DTOS.DetalleHorarioVeterinario;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class DetalleHorarioVeterinarioSalida {

    private Integer detalleHorarioVeterinarioId;
    private Integer veterinarioId;
    private String nombreVeterinario; // Ejemplo de dato adicional
    private Integer diaId;
    private String nombre; // Ejemplo de dato adicional
    private Byte bloqueHorarioId;
    private LocalTime horaInicio; // Ejemplo de dato adicional
    private LocalTime horaFin; // Ejemplo de dato adicional
}