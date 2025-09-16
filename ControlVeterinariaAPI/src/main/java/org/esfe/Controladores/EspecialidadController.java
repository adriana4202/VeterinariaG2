package org.esfe.Controladores;

import lombok.RequiredArgsConstructor;
import org.esfe.DTOS.Especialidad.EspecialidadGuardar;
import org.esfe.DTOS.Especialidad.EspecialidadModificar;
import org.esfe.DTOS.Especialidad.EspecialidadSalida;
import org.esfe.Servicios.interfaces.IEspecialidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
@RequiredArgsConstructor
public class EspecialidadController {

    private final IEspecialidadService service;

    @GetMapping
    public List<EspecialidadSalida> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadSalida> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public EspecialidadSalida guardar(@RequestBody EspecialidadGuardar dto) {
        return service.guardar(dto);
    }

    @PutMapping("/{id}")
    public EspecialidadSalida modificar(@PathVariable Integer id, @RequestBody EspecialidadModificar dto) {
        dto.setEspecialidadId(id); // aseguramos que usemos el ID de la URL
        return service.modificar(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

