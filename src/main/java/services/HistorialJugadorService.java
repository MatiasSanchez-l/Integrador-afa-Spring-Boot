package services;

import DTOs.HistorialJugadorDTO;
import exceptions.ServiceException;

import java.util.List;

public interface HistorialJugadorService {
    public void insertarHistorial(HistorialJugadorDTO historialDTO) throws ServiceException;

    public void eliminarHistorial(Integer idHistorial) throws ServiceException;

    public void modificarHistorial(Integer idHistorial, HistorialJugadorDTO historialDTO) throws ServiceException;

    public List<HistorialJugadorDTO> consultarHistorial() throws ServiceException;
}
