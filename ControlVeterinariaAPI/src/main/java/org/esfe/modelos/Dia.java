package org.esfe.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dia")
@Getter
@Setter
public class Dia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DiaId")
    private int diaId;

    @Column(name = "Nombre", length = 20, nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EstadoDiaId", nullable = false)
    private EstadoDia estadoDia;
}