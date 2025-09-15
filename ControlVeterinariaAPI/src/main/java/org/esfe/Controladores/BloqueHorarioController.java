//package org.esfe.Controladores;
//
//import org.esfe.modelos.BloqueHorario;
//import org.esfe.Servicios.interfaces.IBloqueHorarioService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/bloques-horarios")
//public class BloqueHorarioController {
//
//    private final IBloqueHorarioService service;
//
//    public BloqueHorarioController(IBloqueHorarioService service) {
//        this.service = service;
//    }
//
//    @GetMapping
//    public List<BloqueHorario> listar() {
//        return service.listar();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<BloqueHorario> buscarPorId(@PathVariable Byte id) {
//        BloqueHorario bloque = service.buscarPorId(id);
//        return bloque != null ? ResponseEntity.ok(bloque) : ResponseEntity.notFound().build();
//    }
//
//    @PostMapping
//    public BloqueHorario guardar(@RequestBody BloqueHorario bloqueHorario) {
//        return service.guardar(bloqueHorario);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminar(@PathVariable Byte id) {
//        service.eliminar(id);
//        return ResponseEntity.noContent().build();
//    }
//}

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
