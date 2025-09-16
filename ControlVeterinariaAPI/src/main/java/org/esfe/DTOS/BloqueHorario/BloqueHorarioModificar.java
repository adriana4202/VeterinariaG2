package org.esfe.DTOS.BloqueHorario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BloqueHorarioModificar {
    private Integer  id;
    private LocalTime inicio;
    private LocalTime fin;
}
