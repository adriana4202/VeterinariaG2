package org.esfe.Controladores;

import org.esfe.DTOS.Dia.DiaGuardar;
import org.esfe.DTOS.Dia.DiaModificar;
import org.esfe.DTOS.Dia.DiaSalida;
import org.esfe.Servicios.interfaces.IDiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dias")
public class DiaController {

    @Autowired
    private IDiaService diaService;

    @GetMapping
    public ResponseEntity<List<DiaSalida>> listarDias() {
        return ResponseEntity.ok(diaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiaSalida> buscarDiaPorId(@PathVariable int id) {
        return ResponseEntity.ok(diaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DiaSalida> crearDia(@RequestBody DiaGuardar diaDTO) {
        return new ResponseEntity<>(diaService.save(diaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiaSalida> actualizarDia(@PathVariable int id, @RequestBody DiaModificar diaDTO) {
        return ResponseEntity.ok(diaService.update(id, diaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDia(@PathVariable int id) {
        diaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}