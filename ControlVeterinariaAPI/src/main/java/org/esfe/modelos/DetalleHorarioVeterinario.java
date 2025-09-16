package org.esfe.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DetalleHorarioVeterinario")
public class DetalleHorarioVeterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DetalleHorarioVeterinarioId")
    private Integer detalleHorarioVeterinarioId;

    // Relación con Veterinario
    @ManyToOne
    @JoinColumn(name = "VeterinarioId", referencedColumnName = "VeterinarioId")
    private Veterinario veterinario;

    // Relación con Dia
    @ManyToOne
    @JoinColumn(name = "DiaId", referencedColumnName = "DiaId")
    private Dia dia;

    // Relación con BloqueHorario
    @ManyToOne
    @JoinColumn(name = "BloqueHorarioId", referencedColumnName = "BloqueHorarioId")
    private BloqueHorario bloqueHorario;
}
