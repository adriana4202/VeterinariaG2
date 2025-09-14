package org.esfe.Controladores;

import org.esfe.DTOS.EstadoDia.EstadoDiaGuardar;
import org.esfe.DTOS.EstadoDia.EstadoDiaModificar;
import org.esfe.DTOS.EstadoDia.EstadoDiaSalida;
import org.esfe.Servicios.interfaces.IEstadoDiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estados-dia")
public class EstadoDiaController {

    @Autowired
    private IEstadoDiaService estadoDiaService;

    @GetMapping
    public ResponseEntity<List<EstadoDiaSalida>> listarEstados() {
        return ResponseEntity.ok(estadoDiaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoDiaSalida> buscarEstadoPorId(@PathVariable int id) {
        return ResponseEntity.ok(estadoDiaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EstadoDiaSalida> crearEstado(@RequestBody EstadoDiaGuardar estadoDTO) {
        return new ResponseEntity<>(estadoDiaService.save(estadoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoDiaSalida> actualizarEstado(@PathVariable int id, @RequestBody EstadoDiaModificar estadoDTO) {
        return ResponseEntity.ok(estadoDiaService.update(id, estadoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstado(@PathVariable int id) {
        estadoDiaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}