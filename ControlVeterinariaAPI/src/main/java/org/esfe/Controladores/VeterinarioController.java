package org.esfe.Controladores;

import lombok.RequiredArgsConstructor;
import org.esfe.Servicios.interfaces.IVeterinarioService;
import org.esfe.modelos.Veterinario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
@RequiredArgsConstructor
public class VeterinarioController {

    private final IVeterinarioService servicio;

    // 🔹 Listar todos (activos e inactivos)
    @GetMapping
    public List<Veterinario> listar() {
        return servicio.listar();
    }

    // 🔹 Listar solo activos
    @GetMapping("/activos")
    public List<Veterinario> listarActivos() {
        return servicio.listarActivos();
    }

    // 🔹 Listar solo inactivos
    @GetMapping("/inactivos")
    public List<Veterinario> listarInactivos() {
        return servicio.listarInactivos();
    }

    // 🔹 Guardar nuevo veterinario
    @PostMapping
    public Veterinario guardar(@RequestBody Veterinario veterinario) {
        return servicio.guardar(veterinario);
    }

//    // 🔹 Marcar como inactivo (soft delete)
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> eliminar(@PathVariable Short id) {
//        servicio.eliminar(id);
//        return ResponseEntity.ok("Veterinario marcado como inactivo con éxito");
//    }

    // 🔹 Endpoint más explícito para inactivar
    @PutMapping("/{id}/inactivar")
    public ResponseEntity<String> inactivar(@PathVariable Short id) {
        servicio.eliminar(id);
        return ResponseEntity.ok("Veterinario marcado como inactivo con éxito");
    }

    // 🔹 Reactivar veterinario
    @PutMapping("/{id}/activar")
    public ResponseEntity<String> activar(@PathVariable Short id) {
        servicio.activar(id);
        return ResponseEntity.ok("Veterinario activado con éxito");
    }
}
