package org.esfe.Servicios.Implementaciones;

import lombok.RequiredArgsConstructor;
import org.esfe.DTOS.BloqueHorario.BloqueHorarioGuardar;
import org.esfe.DTOS.BloqueHorario.BloqueHorarioModificar;
import org.esfe.DTOS.BloqueHorario.BloqueHorarioSalida;
import org.esfe.Repositorios.IBloqueHorarioRepository;
import org.esfe.Servicios.interfaces.IBloqueHorarioService;
import org.esfe.modelos.BloqueHorario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BloqueHorarioService implements IBloqueHorarioService {

    private final IBloqueHorarioRepository repositorio;

    @Override
    public List<BloqueHorarioSalida> listar() {
        return repositorio.findByActivoTrue().stream()
                .map(this::toSalidaDTO)
                .toList();
    }

    @Override
    public List<BloqueHorarioSalida> listarInactivos() {
        return repositorio.findByActivoFalse().stream()
                .map(this::toSalidaDTO)
                .toList();
    }

    @Override
    public BloqueHorarioSalida buscarPorId(Integer id) {
        BloqueHorario bloque = repositorio.findById(id)
                .filter(BloqueHorario::getActivo)
                .orElseThrow(() -> new RuntimeException("BloqueHorario no encontrado o inactivo"));

        return toSalidaDTO(bloque);
    }

    @Override
    public BloqueHorarioSalida guardar(BloqueHorarioGuardar dto) {
        BloqueHorario bloque = BloqueHorario.builder()
                .inicio(dto.getInicio())
                .fin(dto.getFin())
                .activo(true)
                .build();

        return toSalidaDTO(repositorio.save(bloque));
    }

    @Override
    public BloqueHorarioSalida modificar(BloqueHorarioModificar dto) {
        BloqueHorario bloque = repositorio.findById(dto.getId())
                .filter(BloqueHorario::getActivo)
                .orElseThrow(() -> new RuntimeException("BloqueHorario no encontrado o inactivo"));

        bloque.setInicio(dto.getInicio());
        bloque.setFin(dto.getFin());

        return toSalidaDTO(repositorio.save(bloque));
    }

    @Override
    public void eliminar(Integer id) {
        BloqueHorario bloque = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("BloqueHorario no encontrado"));

        bloque.setActivo(false);
        repositorio.save(bloque);
    }

    @Override
    public void activar(Integer id) {
        BloqueHorario bloque = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("BloqueHorario no encontrado"));

        bloque.setActivo(true);
        repositorio.save(bloque);
    }

    // ======================
    // 🔹 Mapper
    // ======================
    private BloqueHorarioSalida toSalidaDTO(BloqueHorario b) {
        return BloqueHorarioSalida.builder()
                .id(b.getBloqueHorarioId())
                .inicio(b.getInicio())
                .fin(b.getFin())
                .build();
    }
}
