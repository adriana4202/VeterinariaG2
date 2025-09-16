package org.esfe.DTOS.Especialidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EspecialidadSalida {
    private Integer  especialidadId;
    private String nombre;
}
