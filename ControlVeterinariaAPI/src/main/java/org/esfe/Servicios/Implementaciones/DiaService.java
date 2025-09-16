package org.esfe.Servicios.Implementaciones;

import jakarta.persistence.EntityNotFoundException;
import org.esfe.DTOS.Dia.DiaGuardar;
import org.esfe.DTOS.Dia.DiaModificar;
import org.esfe.DTOS.Dia.DiaSalida;
import org.esfe.Repositorios.IDiaRepository;
import org.esfe.Repositorios.IEstadoDiaRepository;
import org.esfe.Servicios.interfaces.IDiaService;
import org.esfe.modelos.Dia;
import org.esfe.modelos.EstadoDia;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiaService implements IDiaService {

    @Autowired
    private IDiaRepository diaRepository;

    @Autowired
    private IEstadoDiaRepository estadoDiaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DiaSalida> findAll() {
        return diaRepository.findAll().stream()
                .map(dia -> modelMapper.map(dia, DiaSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public DiaSalida findById(int diaId) {
        Dia dia = diaRepository.findById(diaId)
                .orElseThrow(() -> new EntityNotFoundException("Día no encontrado con ID: " + diaId));
        return modelMapper.map(dia, DiaSalida.class);
    }

    @Override
    public DiaSalida save(DiaGuardar diaDTO) {
        EstadoDia estado = estadoDiaRepository.findById(diaDTO.getEstadoDiaId())
                .orElseThrow(() -> new EntityNotFoundException("Estado de día no encontrado con ID: " + diaDTO.getEstadoDiaId()));

        Dia dia = new Dia();
        dia.setNombre(diaDTO.getNombre());
        dia.setEstadoDia(estado);

        dia = diaRepository.save(dia);
        return modelMapper.map(dia, DiaSalida.class);
    }

    @Override
    public DiaSalida update(int diaId, DiaModificar diaDTO) {
        Dia diaExistente = diaRepository.findById(diaId)
                .orElseThrow(() -> new EntityNotFoundException("Día no encontrado con ID: " + diaId));

        EstadoDia estado = estadoDiaRepository.findById(diaDTO.getEstadoDiaId())
                .orElseThrow(() -> new EntityNotFoundException("Estado de día no encontrado con ID: " + diaDTO.getEstadoDiaId()));

        diaExistente.setNombre(diaDTO.getNombre());
        diaExistente.setEstadoDia(estado);
        diaExistente = diaRepository.save(diaExistente);

        return modelMapper.map(diaExistente, DiaSalida.class);
    }

    @Override
    public void deleteById(int diaId) {
        if (!diaRepository.existsById(diaId)) {
            throw new EntityNotFoundException("Día no encontrado con ID: " + diaId);
        }
        diaRepository.deleteById(diaId);
    }
}