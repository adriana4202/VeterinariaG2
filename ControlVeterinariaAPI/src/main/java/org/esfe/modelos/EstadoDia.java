package org.esfe.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estado")
@Getter
@Setter
public class EstadoDia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EstadoDiaId")
    private int estadoDiaId;

    @Column(name = "Nombre", length = 45, nullable = false)
    private String nombre;
}