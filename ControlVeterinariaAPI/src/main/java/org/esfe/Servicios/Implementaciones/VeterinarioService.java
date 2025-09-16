package org.esfe.Servicios.Implementaciones;

import lombok.RequiredArgsConstructor;
import org.esfe.DTOS.veterinario.VeterinarioGuardar;
import org.esfe.DTOS.veterinario.VeterinarioModificar;
import org.esfe.DTOS.veterinario.VeterinarioSalida;
import org.esfe.Repositorios.IVeterinarioRepository;
import org.esfe.Servicios.interfaces.IVeterinarioService;
import org.esfe.modelos.Veterinario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeterinarioService implements IVeterinarioService {

    private final IVeterinarioRepository repositorio;

    @Override
    public List<VeterinarioSalida> listar() {
        return repositorio.findAll().stream()
                .map(this::toSalidaDTO)
                .toList();
    }

    @Override
    public List<VeterinarioSalida> listarActivos() {
        return repositorio.findByEstadoId(1).stream()
                .map(this::toSalidaDTO)
                .toList();
    }

    @Override
    public VeterinarioSalida guardar(VeterinarioGuardar dto) {
        Veterinario veterinario = toEntity(dto);
        veterinario.setEstadoId(1); // Activo por defecto
        return toSalidaDTO(repositorio.save(veterinario));
    }

    @Override
    public VeterinarioSalida modificar(VeterinarioModificar dto) {
        Veterinario veterinario = repositorio.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));

        veterinario.setEspecializacionId(dto.getEspecializacionId());
        veterinario.setNumeroLicencia(dto.getNumeroLicencia());
        veterinario.setRolId(dto.getRolId());
        veterinario.setNickName(dto.getNickName());
        veterinario.setCorreo(dto.getCorreo());
        veterinario.setNombreCompleto(dto.getNombreCompleto());
        veterinario.setDui(dto.getDui());
        veterinario.setTelefono(dto.getTelefono());
        veterinario.setDireccion(dto.getDireccion());
        veterinario.setFechaNacimiento(dto.getFechaNacimiento());

        return toSalidaDTO(repositorio.save(veterinario));
    }

    @Override
    public void inactivar(int id) {
        Veterinario v = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));
        v.setEstadoId(0); // Inactivo
        repositorio.save(v);
    }

    @Override
    public void activar(int id) {
        Veterinario v = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));
        v.setEstadoId(1); // Activo
        repositorio.save(v);
    }

    // Mapeo de DTO de entrada a entidad
    private Veterinario toEntity(VeterinarioGuardar dto) {
        return Veterinario.builder()
                .especializacionId(dto.getEspecializacionId())
                .numeroLicencia(dto.getNumeroLicencia())
                .rolId(dto.getRolId())
                .nickName(dto.getNickName())
                .correo(dto.getCorreo())
                .clave(dto.getClave())
                .nombreCompleto(dto.getNombreCompleto())
                .dui(dto.getDui())
                .telefono(dto.getTelefono())
                .direccion(dto.getDireccion())
                .fechaNacimiento(dto.getFechaNacimiento())
                .build();
    }

    // Mapeo de entidad a DTO de salida
    private VeterinarioSalida toSalidaDTO(Veterinario v) {
        return VeterinarioSalida.builder()
                .id(v.getId())
                .especializacionId(v.getEspecializacionId())
                .numeroLicencia(v.getNumeroLicencia())
                .rolId(v.getRolId())
                .estadoId(v.getEstadoId())
                .nickName(v.getNickName())
                .correo(v.getCorreo())
                .nombreCompleto(v.getNombreCompleto())
                .dui(v.getDui())
                .telefono(v.getTelefono())
                .direccion(v.getDireccion())
                .fechaNacimiento(v.getFechaNacimiento())
                .build();
    }
}
