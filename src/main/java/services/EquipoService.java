package services;


import DTOs.EquipoDTO;

public interface EquipoService {
    public void insertarEquipo(EquipoDTO equipoDTO);

    public void eliminarEquipo(Integer idEquipo);

    public void modificarEquipo(Integer idEquipo, EquipoDTO equipoDTO);

    public EquipoDTO consultarEquipo(Integer idEquipo);
}
