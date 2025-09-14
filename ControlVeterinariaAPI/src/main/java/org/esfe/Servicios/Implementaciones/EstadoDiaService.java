package org.esfe.Servicios.Implementaciones;

import org.esfe.DTOS.EstadoDia.EstadoDiaGuardar;
import org.esfe.DTOS.EstadoDia.EstadoDiaModificar;
import org.esfe.DTOS.EstadoDia.EstadoDiaSalida;
import org.esfe.Servicios.interfaces.IEstadoDiaService;
import org.esfe.modelos.EstadoDia;
import org.esfe.Repositorios.IEstadoDiaRepository;
import org.esfe.Servicios.interfaces.IEstadoDiaService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoDiaService implements IEstadoDiaService {
    @Autowired
    private IEstadoDiaRepository estadoDiaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EstadoDiaSalida> findAll() {
        return estadoDiaRepository.findAll().stream()
                .map(estado -> modelMapper.map(estado, EstadoDiaSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public EstadoDiaSalida findById(int estadoDiaId) {
        EstadoDia estado = estadoDiaRepository.findById(estadoDiaId)
                .orElseThrow(() -> new EntityNotFoundException("Estado no encontrado con ID: " + estadoDiaId));
        return modelMapper.map(estado, EstadoDiaSalida.class);
    }

    @Override
    public EstadoDiaSalida save(EstadoDiaGuardar estadoDiaDTO) {
        EstadoDia estado = modelMapper.map(estadoDiaDTO, EstadoDia.class);
        estado = estadoDiaRepository.save(estado);
        return modelMapper.map(estado, EstadoDiaSalida.class);
    }

    @Override
    public EstadoDiaSalida update(int estadoDiaId, EstadoDiaModificar estadoDiaDTO) {
        EstadoDia estadoExistente = estadoDiaRepository.findById(estadoDiaId)
                .orElseThrow(() -> new EntityNotFoundException("Estado no encontrado con ID: " + estadoDiaId));

        estadoExistente.setNombre(estadoDiaDTO.getNombre());
        estadoExistente = estadoDiaRepository.save(estadoExistente);

        return modelMapper.map(estadoExistente, EstadoDiaSalida.class);
    }

    @Override
    public void deleteById(int estadoDiaId) {
        if (!estadoDiaRepository.existsById(estadoDiaId)) {
            throw new EntityNotFoundException("Estado no encontrado con ID: " + estadoDiaId);
        }
        estadoDiaRepository.deleteById(estadoDiaId);
    }
}