package org.esfe.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
