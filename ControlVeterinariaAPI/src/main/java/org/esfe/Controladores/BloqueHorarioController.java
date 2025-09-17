package org.esfe.Controladores;

import lombok.RequiredArgsConstructor;
import org.esfe.DTOS.BloqueHorario.BloqueHorarioGuardar;
import org.esfe.DTOS.BloqueHorario.BloqueHorarioModificar;
import org.esfe.DTOS.BloqueHorario.BloqueHorarioSalida;
import org.esfe.Servicios.interfaces.IBloqueHorarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bloques-horario")
@RequiredArgsConstructor
public class BloqueHorarioController {

    private final IBloqueHorarioService service;

    @GetMapping("/activos")
    public List<BloqueHorarioSalida> listar() {
        return service.listar();
    }

    @GetMapping("/inactivos")
    public List<BloqueHorarioSalida> listarInactivos() {
        return service.listarInactivos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BloqueHorarioSalida> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping("/crear")
    public BloqueHorarioSalida guardar(@RequestBody BloqueHorarioGuardar dto) {
        return service.guardar(dto);
    }

    @PutMapping("/{id}/editar")
    public BloqueHorarioSalida modificar(@PathVariable Integer id, @RequestBody BloqueHorarioModificar dto) {
        dto.setId(id);
        return service.modificar(dto);
    }

    @PutMapping("/{id}/activar")
    public ResponseEntity<Map<String, Object>> activar(@PathVariable Integer id) {
        service.activar(id);

        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "BloqueHorario activado correctamente");
        response.put("id", id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}/desactivar")
    public ResponseEntity<Map<String, Object>> eliminar(@PathVariable Integer id) {
        service.eliminar(id);

        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "BloqueHorario desactivado correctamente");
        response.put("id", id);

        return ResponseEntity.ok(response);
    }
}

