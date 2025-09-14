package org.esfe.DTOS.veterinario;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeterinarioSalida {
    private Short id;
    private Byte especializacionId;
    private String numeroLicencia;
    private Byte rolId;
    private Byte estadoId;
    private String nickName;
    private String correo;
    private String nombreCompleto;
    private String dui;
    private String telefono;
    private String direccion;
    private LocalDate fechaNacimiento;
}
