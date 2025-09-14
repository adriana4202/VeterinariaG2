package org.esfe.Servicios.Implementaciones;

import lombok.RequiredArgsConstructor;
import org.esfe.Repositorios.IVeterinarioRepository;
import org.esfe.Servicios.interfaces.IVeterinarioService;
import org.esfe.modelos.Veterinario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VeterinarioService implements IVeterinarioService {

    private final IVeterinarioRepository repositorio;

    @Override
    public List<Veterinario> listar() {
        return repositorio.findAll();
    }

    @Override
    public List<Veterinario> listarActivos() {
        return repositorio.findByEstadoId((byte) 1);
    }

    @Override
    public List<Veterinario> listarInactivos() {
        return repositorio.findByEstadoId((byte) 0);
    }

    @Override
    public Veterinario guardar(Veterinario veterinario) {
        return repositorio.save(veterinario);
    }

    @Override
    public void activar(Short id) {
        Veterinario veterinario = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));
        veterinario.setEstadoId((byte) 1);
        repositorio.save(veterinario);
    }

    @Override
    public void eliminar(Short id) {
        Veterinario veterinario = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));
        veterinario.setEstadoId((byte) 0);
        repositorio.save(veterinario);
    }

    @Override
    public Optional<Veterinario> buscarPorId(Short id) {
        return repositorio.findById(id);
    }
}
