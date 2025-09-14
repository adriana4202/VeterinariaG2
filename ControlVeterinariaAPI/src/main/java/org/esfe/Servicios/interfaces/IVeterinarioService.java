package org.esfe.Servicios.interfaces;

import org.esfe.modelos.Veterinario;

import java.util.List;
import java.util.Optional;

public interface IVeterinarioService {
    List<Veterinario> listar();                  // todos (activos e inactivos)
    List<Veterinario> listarActivos();           // solo activos
    List<Veterinario> listarInactivos();         // solo inactivos
    Veterinario guardar(Veterinario veterinario);
    void eliminar(Short id);                     // marcar como inactivo
    void activar(Short id);                      // reactivar
    Optional<Veterinario> buscarPorId(Short id); // buscar por id
}
