package org.esfe.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Veterinario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VeterinarioId")
    private Short id;

    @Column(name = "EspecializacionId")
    private Byte especializacionId; // después será @ManyToOne con Especialidad

    // -------- DATOS QUE PROVIENEN DE USUARIO (temporalmente copiados aquí) --------
    @Column(name = "NumeroLicencia", length = 60, nullable = false)
    private String numeroLicencia;

    @Column(name = "RolId")
    private Byte rolId;

    @Column(name = "EstadoId")
    private Byte estadoId;

    @Column(name = "NickName", length = 60)
    private String nickName;

    @Column(name = "Correo", length = 120, nullable = false, unique = true)
    private String correo;

    @Column(name = "Clave", length = 255, nullable = false)
    private String clave;

    @Column(name = "NombreCompleto", length = 120, nullable = false)
    private String nombreCompleto;

    @Column(name = "Dui", length = 20, unique = true)
    private String dui;

    @Column(name = "Telefono", length = 32)
    private String telefono;

    @Column(name = "Direccion", length = 200)
    private String direccion;

    @Column(name = "FechaNacimiento")
    private LocalDate fechaNacimiento;
}
