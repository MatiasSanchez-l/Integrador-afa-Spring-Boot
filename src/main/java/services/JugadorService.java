package services;

import DTOs.JugadorDTO;
import exceptions.ServiceException;

import java.util.List;

public interface JugadorService {
    public void insertarJugador(JugadorDTO jugadorDTO) throws ServiceException;

    public void eliminarJugador(Integer idJugador) throws ServiceException;

    public void modificarJugador(Integer idJugador, JugadorDTO jugadorDTO) throws ServiceException;

    public List<JugadorDTO> consultarJugador(Integer idJugador) throws ServiceException;
}
