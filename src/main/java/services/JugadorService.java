package services;

import DTOs.JugadorDTO;

public interface JugadorService {
    public void insertarJugador(JugadorDTO jugadorDTO);

    public void eliminarJugador(Integer idJugador);

    public void modificarJugador(Integer idJugador, JugadorDTO jugadorDTO);

    public JugadorDTO consultarJugador(Integer idJugador);
}
