package services.servicesImpl;

import DTOs.HistorialJugadorDTO;
import entities.Equipo;
import entities.HistorialJugador;
import entities.Jugador;
import exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.HistorialJugadorRepository;
import services.HistorialJugadorService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HistorialJugadorServiceImpl implements HistorialJugadorService {
    @Autowired
    HistorialJugadorRepository historialJugadorRepository;

    @Override
    public void insertarHistorial(HistorialJugadorDTO historialDTO) throws ServiceException {

        try{
            HistorialJugador historial = convertirHistorialJugadorDtoAEntity(historialDTO);
            historialJugadorRepository.save(historial);
        }catch (Exception e){
            throw new ServiceException("DireccionService Error: Error en insertar " + e.getCause());
        }
    }

    @Override
    public void eliminarHistorial(Integer idHistorial) throws ServiceException {
        try{
            historialJugadorRepository.deleteById(idHistorial);
        }catch (Exception e){
            throw new ServiceException("DireccionService Error: Error en eliminar " + e.getCause());
        }

    }

    @Override
    public void modificarHistorial(Integer idHistorial, HistorialJugadorDTO historialDTO) throws ServiceException {
        try{
            HistorialJugador historial = convertirHistorialJugadorDtoAEntity(historialDTO);
            historial.setId(idHistorial);
            historialJugadorRepository.save(historial);
        }catch (Exception e){
            throw new ServiceException("DireccionService Error: Error en modificar " + e.getCause());
        }
    }

    @Override
    public List<HistorialJugadorDTO> consultarHistorial(Integer idHistorial) throws ServiceException {
        try{
            Iterable<HistorialJugador> historiales = historialJugadorRepository.findAll();
            List<HistorialJugadorDTO> historialesDTO = new ArrayList<>();
            for (HistorialJugador historial: historiales) {
                HistorialJugadorDTO historialDTO = convertirHistorialJugadorEntityADto(historial);
                historialesDTO.add(historialDTO);
            }
            return historialesDTO;
        }catch (Exception e){
            throw new ServiceException("DireccionService Error: Error en consultar " + e.getCause());
        }
    }

    public HistorialJugador convertirHistorialJugadorDtoAEntity(HistorialJugadorDTO historialDto) {
        LocalDate fechaInicioContrato = historialDto.getFechaInicioContrato();
        LocalDate fechaFinContrato = historialDto.getFechaFinContrato();
        String posicion = historialDto.getPosicion();
        Equipo equipo = historialDto.getEquipo();
        Jugador jugador = historialDto.getJugador();

        HistorialJugador historialJugador = new HistorialJugador();

        historialJugador.setFechaInicioContrato(fechaInicioContrato);
        historialJugador.setFechaFinContrato(fechaFinContrato);
        historialJugador.setPosicion(posicion);
        historialJugador.setEquipo(equipo);
        historialJugador.setJugador(jugador);

        return historialJugador;
    }

    public HistorialJugadorDTO convertirHistorialJugadorEntityADto(HistorialJugador historial) {

        HistorialJugadorDTO historialJugadorDto = new HistorialJugadorDTO();
        historialJugadorDto.setFechaInicioContrato(historial.getFechaInicioContrato());
        historialJugadorDto.setPosicion(historial.getPosicion());
        historialJugadorDto.setFechaFinContrato(historial.getFechaFinContrato());
        historialJugadorDto.setEquipo(historial.getEquipo());
        historialJugadorDto.setJugador(historial.getJugador());

        return historialJugadorDto;
    }
}
