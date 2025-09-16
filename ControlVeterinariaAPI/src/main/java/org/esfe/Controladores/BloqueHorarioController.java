
package org.esfe.Controladores;

import lombok.RequiredArgsConstructor;
import org.esfe.DTOS.BloqueHorario.BloqueHorarioGuardar;
import org.esfe.DTOS.BloqueHorario.BloqueHorarioModificar;
import org.esfe.DTOS.BloqueHorario.BloqueHorarioSalida;
import org.esfe.Servicios.interfaces.IBloqueHorarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bloques-horario")
@RequiredArgsConstructor
public class BloqueHorarioController {

    private final IBloqueHorarioService service;

    @GetMapping
    public List<BloqueHorarioSalida> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BloqueHorarioSalida> buscarPorId(@PathVariable Integer id) {
        BloqueHorarioSalida dto = service.buscarPorId(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public BloqueHorarioSalida guardar(@RequestBody BloqueHorarioGuardar dto) {
        return service.guardar(dto);
    }

    @PutMapping
    public BloqueHorarioSalida modificar(@RequestBody BloqueHorarioModificar dto) {
        return service.modificar(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
