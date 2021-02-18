package services;

import DTOs.HistorialJugadorDTO;

public interface HistorialJugadorService {
    public void insertarHistorial(HistorialJugadorDTO historialDTO);

    public void eliminarHistorial(Integer idHistorial);

    public void modificarHistorial(Integer idHistorial, HistorialJugadorDTO historialDTO);

    public HistorialJugadorDTO consultarHistorial(Integer idHistorial);
}
