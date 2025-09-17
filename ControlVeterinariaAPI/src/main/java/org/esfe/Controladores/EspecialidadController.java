package org.esfe.Controladores;

import lombok.RequiredArgsConstructor;
import org.esfe.DTOS.Especialidad.EspecialidadGuardar;
import org.esfe.DTOS.Especialidad.EspecialidadModificar;
import org.esfe.DTOS.Especialidad.EspecialidadSalida;
import org.esfe.Servicios.interfaces.IEspecialidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/especialidades")
@RequiredArgsConstructor
public class EspecialidadController {

    private final IEspecialidadService service;

    @GetMapping("/activos")
    public List<EspecialidadSalida> listar() {
        return service.listar();
    }

    @GetMapping("/inactivos")
    public List<EspecialidadSalida> listarInactivos() {
        return service.listarInactivos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadSalida> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping("/Crear")
    public EspecialidadSalida guardar(@RequestBody EspecialidadGuardar dto) {
        return service.guardar(dto);
    }

    @PutMapping("/{id}/editar")
    public EspecialidadSalida modificar(@PathVariable Integer id, @RequestBody EspecialidadModificar dto) {
        dto.setEspecialidadId(id); // aseguramos que usemos el ID de la URL
        return service.modificar(dto);
    }

    @PutMapping("/{id}/activar")
    public ResponseEntity<Map<String, Object>> activar(@PathVariable Integer id) {
        service.activar(id);

        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Especialidad activada correctamente");
        response.put("id", id);

        return ResponseEntity.ok(response);
    }

@DeleteMapping("/{id}/desactivar")
public ResponseEntity<Map<String, Object>> eliminar(@PathVariable Integer id) {
    service.eliminar(id);

    Map<String, Object> response = new HashMap<>();
    response.put("mensaje", "Especialidad desactivada correctamente");
    response.put("id", id);

    return ResponseEntity.ok(response);
}

}

