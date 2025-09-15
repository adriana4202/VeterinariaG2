package org.esfe.DTOS.Especialidad;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EspecialidadSalida {
    private Integer  especialidadId;
    private String nombre;
}
