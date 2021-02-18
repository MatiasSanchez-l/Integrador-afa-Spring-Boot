package services;

import DTOs.DireccionDTO;

public interface DireccionService {
    public void insertarDireccion(DireccionDTO direccionDTO);

    public void eliminarDireccion(Integer idDireccion);

    public void modificarDireccion(Integer idDireccion, DireccionDTO direccionDTO);

    public DireccionDTO consultarDireccion(Integer idDireccion);
}
