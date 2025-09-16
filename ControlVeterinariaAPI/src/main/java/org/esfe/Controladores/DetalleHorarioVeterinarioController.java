package org.esfe.Controladores;

import org.esfe.DTOS.DetalleHorarioVeterinario.DetalleHorarioVeterinarioGuardar;
import org.esfe.DTOS.DetalleHorarioVeterinario.DetalleHorarioVeterinarioSalida;
import org.esfe.Servicios.interfaces.IDetalleHorarioVeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/detallehorarioveterinario")
public class DetalleHorarioVeterinarioController {

    @Autowired
    private IDetalleHorarioVeterinarioService detalleHorarioVeterinarioService;

    @GetMapping
    public ResponseEntity<List<DetalleHorarioVeterinarioSalida>> listarTodos() {
        return ResponseEntity.ok(detalleHorarioVeterinarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleHorarioVeterinarioSalida> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(detalleHorarioVeterinarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DetalleHorarioVeterinarioSalida> crear(@RequestBody DetalleHorarioVeterinarioGuardar detalleDTO) {
        return new ResponseEntity<>(detalleHorarioVeterinarioService.save(detalleDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleHorarioVeterinarioSalida> actualizar(@PathVariable Integer id, @RequestBody DetalleHorarioVeterinarioGuardar detalleDTO) {
        return ResponseEntity.ok(detalleHorarioVeterinarioService.update(id, detalleDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        detalleHorarioVeterinarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}