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
        return repositorio.findAll().stream()
                .map(this::toSalidaDTO)
                .toList();
    }

    @Override
    public BloqueHorarioSalida buscarPorId(Integer id) {
        return repositorio.findById(id)
                .map(this::toSalidaDTO)
                .orElse(null);
    }

    @Override
    public BloqueHorarioSalida guardar(BloqueHorarioGuardar dto) {
        BloqueHorario bloque = BloqueHorario.builder()
                .inicio(dto.getInicio())
                .fin(dto.getFin())
                .build();
        return toSalidaDTO(repositorio.save(bloque));
    }

    @Override
    public BloqueHorarioSalida modificar(BloqueHorarioModificar dto) {
        BloqueHorario bloque = repositorio.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("BloqueHorario no encontrado"));

        bloque.setInicio(dto.getInicio());
        bloque.setFin(dto.getFin());

        return toSalidaDTO(repositorio.save(bloque));
    }

    @Override
    public void eliminar(Integer id) {
        repositorio.deleteById(id);
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
