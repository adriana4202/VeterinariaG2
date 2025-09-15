package org.esfe.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table(name = "BloqueHorario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BloqueHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BloqueHorarioId", nullable = false)
    private Integer bloqueHorarioId;

    @Column(name = "Inicio", nullable = false)
    private LocalTime inicio;

    @Column(name = "Fin", nullable = false)
    private LocalTime fin;
}
