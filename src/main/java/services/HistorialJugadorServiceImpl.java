package services;

import DTOs.HistorialJugadorDTO;
import entities.Equipo;
import entities.HistorialJugador;
import entities.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.HistorialJugadorRepository;

import java.time.LocalDate;

@Service
public class HistorialJugadorServiceImpl implements HistorialJugadorService{
    @Autowired
    HistorialJugadorRepository historialJugadorRepository;

    @Override
    public void insertarHistorial(HistorialJugadorDTO historialDTO) {
        HistorialJugador historial = convertirHistorialJugadorDtoAEntity(historialDTO);
        historialJugadorRepository.save(historial);
    }

    @Override
    public void eliminarHistorial(Integer idHistorial) {
        historialJugadorRepository.deleteById(idHistorial);
    }

    @Override
    public void modificarHistorial(Integer idHistorial, HistorialJugadorDTO historialDTO) {
        HistorialJugador historial = convertirHistorialJugadorDtoAEntity(historialDTO);
        historial.setId(idHistorial);
        historialJugadorRepository.save(historial);
    }

    @Override
    public HistorialJugadorDTO consultarHistorial(Integer idHistorial) {
        HistorialJugador historial = historialJugadorRepository.findById(idHistorial).get();
        HistorialJugadorDTO historialDTO = convertirHistorialJugadorEntityADto(historial);
        return historialDTO;
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
