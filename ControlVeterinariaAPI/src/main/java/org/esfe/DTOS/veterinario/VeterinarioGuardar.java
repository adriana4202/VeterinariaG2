package org.esfe.DTOS.veterinario;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeterinarioGuardar {
    private Byte especializacionId;
    private String numeroLicencia;
    private Byte rolId;
    private String nickName;
    private String correo;
    private String clave;
    private String nombreCompleto;
    private String dui;
    private String telefono;
    private String direccion;
    private LocalDate fechaNacimiento;
}
