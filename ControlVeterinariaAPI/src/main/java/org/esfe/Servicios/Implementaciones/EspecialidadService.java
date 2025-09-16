package org.esfe.Servicios.Implementaciones;

import lombok.RequiredArgsConstructor;
import org.esfe.DTOS.Especialidad.EspecialidadGuardar;
import org.esfe.DTOS.Especialidad.EspecialidadModificar;
import org.esfe.DTOS.Especialidad.EspecialidadSalida;
import org.esfe.Repositorios.IEspecialidadRepository;
import org.esfe.Servicios.interfaces.IEspecialidadService;
import org.esfe.modelos.Especialidad;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EspecialidadService implements IEspecialidadService {

    private final IEspecialidadRepository repositorio;

    @Override
    public List<EspecialidadSalida> listar() {
        return repositorio.findAll().stream()
                .map(this::toSalidaDTO)
                .toList();
    }

    @Override
    public EspecialidadSalida buscarPorId(Integer id) {
        return repositorio.findById(id)
                .map(this::toSalidaDTO)
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));
    }

    @Override
    public EspecialidadSalida guardar(EspecialidadGuardar dto) {
        Especialidad especialidad = toEntity(dto);
        return toSalidaDTO(repositorio.save(especialidad));
    }

    @Override
    public EspecialidadSalida modificar(EspecialidadModificar dto) {
        Especialidad especialidad = repositorio.findById(dto.getEspecialidadId())
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));

        especialidad.setNombre(dto.getNombre());

        return toSalidaDTO(repositorio.save(especialidad));
    }

    @Override
    public void eliminar(Integer id) {
        if (!repositorio.existsById(id)) {
            throw new RuntimeException("Especialidad no encontrada");
        }
        repositorio.deleteById(id);
    }

    // ======================
    // 🔹 Mappers manuales
    // ======================
    private Especialidad toEntity(EspecialidadGuardar dto) {
        return Especialidad.builder()
                .nombre(dto.getNombre())
                .build();
    }

    private EspecialidadSalida toSalidaDTO(Especialidad especialidad) {
        return EspecialidadSalida.builder()
                .especialidadId(especialidad.getEspecialidadId())
                .nombre(especialidad.getNombre())
                .build();
    }
}
