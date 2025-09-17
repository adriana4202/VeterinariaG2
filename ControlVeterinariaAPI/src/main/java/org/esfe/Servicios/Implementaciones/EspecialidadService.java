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
        return repositorio.findByActivoTrue().stream() // 🔹 solo activos
                .map(this::toSalidaDTO)
                .toList();
    }

    @Override
    public List<EspecialidadSalida> listarInactivos() {
        return repositorio.findByActivoFalse().stream() // solo inactivos
                .map(this::toSalidaDTO)
                .toList();
    }


    @Override
    public EspecialidadSalida buscarPorId(Integer id) {
        Especialidad especialidad = repositorio.findById(id)
                .filter(Especialidad::getActivo) // 🔹 aseguramos que esté activo
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada o inactiva"));
        return toSalidaDTO(especialidad);
    }

    @Override
    public EspecialidadSalida guardar(EspecialidadGuardar dto) {
        Especialidad especialidad = toEntity(dto);
        especialidad.setActivo(true); // 🔹 nuevo registro siempre activo
        return toSalidaDTO(repositorio.save(especialidad));
    }

    @Override
    public EspecialidadSalida modificar(EspecialidadModificar dto) {
        Especialidad especialidad = repositorio.findById(dto.getEspecialidadId())
                .filter(Especialidad::getActivo) // 🔹 solo modificar si está activo
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada o inactiva"));

        especialidad.setNombre(dto.getNombre());

        return toSalidaDTO(repositorio.save(especialidad));
    }

    @Override
    public void eliminar(Integer id) {
        Especialidad especialidad = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));

        especialidad.setActivo(false); // 🔹 en lugar de borrar, se inactiva
        repositorio.save(especialidad);
    }

    @Override
    public void activar(Integer id) {
        Especialidad especialidad = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));

        especialidad.setActivo(true);
        repositorio.save(especialidad);
    }


    // ======================
    // 🔹 Mappers manuales
    // ======================
    private Especialidad toEntity(EspecialidadGuardar dto) {
        return Especialidad.builder()
                .nombre(dto.getNombre())
                .activo(true) // 🔹 al crear siempre activo
                .build();
    }

    private EspecialidadSalida toSalidaDTO(Especialidad especialidad) {
        return EspecialidadSalida.builder()
                .especialidadId(especialidad.getEspecialidadId())
                .nombre(especialidad.getNombre())
                .build();
    }
}

