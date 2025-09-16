package org.esfe.DTOS.veterinario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeterinarioGuardar {
    private int especializacionId;
    private String numeroLicencia;
    private int rolId;
    private String nickName;
    private String correo;
    private String clave;
    private String nombreCompleto;
    private String dui;
    private String telefono;
    private String direccion;
    private LocalDate fechaNacimiento;
}
