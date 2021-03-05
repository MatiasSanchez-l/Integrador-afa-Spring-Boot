package services;

import DTOs.DireccionDTO;
import exceptions.ServiceException;

import java.util.List;

public interface DireccionService {
    public void insertarDireccion(DireccionDTO direccionDTO) throws ServiceException;

    public void eliminarDireccion(Integer idDireccion) throws ServiceException;

    public void modificarDireccion(Integer idDireccion, DireccionDTO direccionDTO) throws ServiceException;

    public List<DireccionDTO> consultarDireccion(Integer idDireccion) throws ServiceException;
}
