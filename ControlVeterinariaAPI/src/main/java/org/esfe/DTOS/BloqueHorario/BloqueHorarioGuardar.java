package org.esfe.DTOS.BloqueHorario;

import lombok.*;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BloqueHorarioGuardar {
    private LocalTime inicio;
    private LocalTime fin;
}
