package org.esfe.Controladores;

import lombok.RequiredArgsConstructor;
import org.esfe.DTOS.veterinario.VeterinarioGuardar;
import org.esfe.DTOS.veterinario.VeterinarioModificar;
import org.esfe.DTOS.veterinario.VeterinarioSalida;
import org.esfe.Servicios.interfaces.IVeterinarioService;
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
    public List<VeterinarioSalida> listar() {
        return servicio.listar();
    }

    // 🔹 Listar solo activos
    @GetMapping("/activos")
    public List<VeterinarioSalida> listarActivos() {
        return servicio.listarActivos();
    }

    // 🔹 Guardar nuevo veterinario
    @PostMapping
    public VeterinarioSalida guardar(@RequestBody VeterinarioGuardar dto) {
        return servicio.guardar(dto);
    }

    // 🔹 Modificar veterinario
    @PutMapping
    public VeterinarioSalida modificar(@RequestBody VeterinarioModificar dto) {
        return servicio.modificar(dto);
    }

    // 🔹 Inactivar (soft delete)
    @PutMapping("/{id}/inactivar")
    public ResponseEntity<String> inactivar(@PathVariable Short id) {
        servicio.inactivar(id);
        return ResponseEntity.ok("Veterinario marcado como inactivo con éxito");
    }

    // 🔹 Reactivar veterinario
    @PutMapping("/{id}/activar")
    public ResponseEntity<String> activar(@PathVariable Short id) {
        servicio.activar(id);
        return ResponseEntity.ok("Veterinario activado con éxito");
    }
}
