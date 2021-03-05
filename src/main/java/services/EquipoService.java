package services;



import DTOs.EquipoDTO;
import exceptions.ServiceException;

import java.util.List;

public interface EquipoService {
    public void insertarEquipo(EquipoDTO equipoDTO) throws ServiceException;

    public void eliminarEquipo(Integer idEquipo) throws ServiceException;

    public void modificarEquipo(Integer idEquipo, EquipoDTO equipoDTO) throws ServiceException;

    public List<EquipoDTO> consultarEquipo(Integer idEquipo) throws ServiceException;
}
