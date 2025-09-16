//package org.esfe.Servicios.implementaciones;
//
//import org.esfe.DTOS.DetalleHorarioVeterinario.DetalleHorarioVeterinarioGuardar;
//import org.esfe.DTOS.DetalleHorarioVeterinario.DetalleHorarioVeterinarioSalida;
//import org.esfe.Repositorios.IDetalleHorarioVeterinarioRepository;
////import org.esfe.Repositorios.IVeterinarioRepository;
////import org.esfe.Repositorios.IDiaRepository;
////import org.esfe.Repositorios.IBloqueHorarioRepository;
//import org.esfe.Servicios.interfaces.IDetalleHorarioVeterinarioService;
//import org.esfe.modelos.DetalleHorarioVeterinario;
//import org.esfe.modelos.Veterinario;
//import org.esfe.modelos.Dia;
//import org.esfe.modelos.BloqueHorario;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class DetalleHorarioVeterinarioServiceImpl implements IDetalleHorarioVeterinarioService {
//
//    @Autowired
//    private IDetalleHorarioVeterinarioRepository detalleHorarioVeterinarioRepository;
//
//    // Inyección de los repositorios de las entidades relacionadas
//    @Autowired
//    private IVeterinarioRepository veterinarioRepository;
//    @Autowired
//    private IDiaRepository diaRepository;
//    @Autowired
//    private IBloqueHorarioRepository bloqueHorarioRepository;
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<DetalleHorarioVeterinarioSalida> findAll() {
//        List<DetalleHorarioVeterinario> detalles = detalleHorarioVeterinarioRepository.findAll();
//        return detalles.stream()
//                .map(this::convertirA_DtoSalida)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public DetalleHorarioVeterinarioSalida findById(Integer id) {
//        return detalleHorarioVeterinarioRepository.findById(id)
//                .map(this::convertirA_DtoSalida)
//                .orElse(null);
//    }
//
//    @Override
//    @Transactional
//    public DetalleHorarioVeterinarioSalida save(DetalleHorarioVeterinarioGuardar detalleDTO) {
//        DetalleHorarioVeterinario detalle = new DetalleHorarioVeterinario();
//
//        // Buscar las entidades por ID para asegurar que existen y son válidas
//        Optional<Veterinario> veterinarioOpt = veterinarioRepository.findById(detalleDTO.getVeterinarioId().shortValue());
//        Optional<Dia> diaOpt = diaRepository.findById(detalleDTO.getDiaId());
//        Optional<BloqueHorario> bloqueHorarioOpt = bloqueHorarioRepository.findById(detalleDTO.getBloqueHorarioId().intValue());
//
//        if (veterinarioOpt.isPresent() && diaOpt.isPresent() && bloqueHorarioOpt.isPresent()) {
//            detalle.setVeterinario(veterinarioOpt.get());
//            detalle.setDia(diaOpt.get());
//            detalle.setBloqueHorario(bloqueHorarioOpt.get());
//
//            DetalleHorarioVeterinario guardado = detalleHorarioVeterinarioRepository.save(detalle);
//            return convertirA_DtoSalida(guardado);
//        }
//
//        // Retornar null o lanzar una excepción si alguna de las entidades relacionadas no se encuentra
//        return null;
//    }
//
//    @Override
//    @Transactional
//    public DetalleHorarioVeterinarioSalida update(Integer id, DetalleHorarioVeterinarioGuardar detalleDTO) {
//        return detalleHorarioVeterinarioRepository.findById(id)
//                .map(detalle -> {
//                    // Buscar las entidades por ID para la actualización
//                    Optional<Veterinario> veterinarioOpt = veterinarioRepository.findById(detalleDTO.getVeterinarioId().shortValue());
//                    Optional<Dia> diaOpt = diaRepository.findById(detalleDTO.getDiaId());
//                    Optional<BloqueHorario> bloqueHorarioOpt = bloqueHorarioRepository.findById(detalleDTO.getBloqueHorarioId().intValue());
//
//                    if (veterinarioOpt.isPresent() && diaOpt.isPresent() && bloqueHorarioOpt.isPresent()) {
//                        detalle.setVeterinario(veterinarioOpt.get());
//                        detalle.setDia(diaOpt.get());
//                        detalle.setBloqueHorario(bloqueHorarioOpt.get());
//
//                        DetalleHorarioVeterinario actualizado = detalleHorarioVeterinarioRepository.save(detalle);
//                        return convertirA_DtoSalida(actualizado);
//                    }
//                    return null; // Retornar null o manejar el error si no se encuentran las entidades
//                })
//                .orElse(null);
//    }
//
//    @Override
//    @Transactional
//    public void deleteById(Integer id) {
//        detalleHorarioVeterinarioRepository.deleteById(id);
//    }
//
//    private DetalleHorarioVeterinarioSalida convertirA_DtoSalida(DetalleHorarioVeterinario detalle) {
//        DetalleHorarioVeterinarioSalida dto = new DetalleHorarioVeterinarioSalida();
//
//        dto.setDetalleHorarioVeterinarioId(detalle.getDetalleHorarioVeterinarioId());
//
//        if (detalle.getVeterinario() != null) {
//            dto.setVeterinarioId(detalle.getVeterinario().getId().intValue());
//            dto.setNombreVeterinario(detalle.getVeterinario().getNombreCompleto());
//        }
//        if (detalle.getDia() != null) {
//            dto.setDiaId(detalle.getDia().getDiaId());
//            dto.setNombre(detalle.getDia().getNombre());
//        }
//        if (detalle.getBloqueHorario() != null) {
//            dto.setBloqueHorarioId(detalle.getBloqueHorario().getBloqueHorarioId().byteValue());
//            dto.setHoraInicio(detalle.getBloqueHorario().getInicio());
//            dto.setHoraFin(detalle.getBloqueHorario().getFin());
//        }
//
//        return dto;
//    }
//}