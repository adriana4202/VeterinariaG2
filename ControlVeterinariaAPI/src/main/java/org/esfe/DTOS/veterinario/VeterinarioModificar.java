package org.esfe.DTOS.veterinario;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeterinarioModificar {
    private int id;
    private int especializacionId;
    private String numeroLicencia;
    private int rolId;
    private String nickName;
    private String correo;
    private String nombreCompleto;
    private String dui;
    private String telefono;
    private String direccion;
    private LocalDate fechaNacimiento;
}
