package services;


import DTOs.JugadorDTO;
import entities.Direccion;
import entities.Equipo;
import entities.HistorialJugador;
import entities.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.JugadorRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class JugadorServiceImpl implements JugadorService{
    @Autowired
    JugadorRepository jugadorRepository;

    @Override
    public void insertarJugador(JugadorDTO jugadorDTO) {
        Jugador jugador = convertirJugadorDtoAEntity(jugadorDTO);
        jugadorRepository.save(jugador);
    }

    @Override
    public void eliminarJugador(Integer idJugador) {
        jugadorRepository.deleteById(idJugador);
    }

    @Override
    public void modificarJugador(Integer idJugador, JugadorDTO jugadorDTO) {
        Jugador jugador = convertirJugadorDtoAEntity(jugadorDTO);
        jugador.setId(idJugador);
        jugadorRepository.save(jugador);
    }

    @Override
    public JugadorDTO consultarJugador(Integer idJugador) {
        Jugador jugador = jugadorRepository.findById(idJugador).get();
        JugadorDTO jugadorDTO = convertirJugadorEntityADTO(jugador);
        return jugadorDTO;
    }

    public Jugador convertirJugadorDtoAEntity(JugadorDTO jugadorDto) {

        String nombre = jugadorDto.getNombre();
        String apellido = jugadorDto.getApellido();
        Integer dni = jugadorDto.getDni();
        Integer telefono = jugadorDto.getTelefono();
        String email = jugadorDto.getEmail();
        LocalDate fechaDebut = jugadorDto.getFechaDebut();
        LocalDate fechaNacimiento = jugadorDto.getFechaNacimiento();
        LocalDate fechaRetiro = jugadorDto.getFechaRetiro();
        Integer cantidadPartidos = jugadorDto.getCantidadPartidos();
        Integer cantidadGoles = jugadorDto.getCantidadGoles();
        Float peso = jugadorDto.getPeso();
        Float altura = jugadorDto.getAltura();
        Equipo equipo = jugadorDto.getEquipo();
        List<HistorialJugador> historiales = jugadorDto.getHistoriales();
        Direccion direccion = jugadorDto.getDireccion();


        Jugador jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setApellido(apellido);
        jugador.setDni(dni);
        jugador.setTelefono(telefono);
        jugador.setEmail(email);
        jugador.setFechaDebut(fechaDebut);
        jugador.setFechaNacimiento(fechaNacimiento);
        jugador.setCantidadPartidos(cantidadPartidos);
        jugador.setCantidadGoles(cantidadGoles);
        jugador.setPeso(peso);
        jugador.setAltura(altura);
        jugador.setEquipo(equipo);
        jugador.setHistoriales(historiales);
        jugador.setDireccion(direccion);
        jugador.setFechaRetiro(fechaRetiro);

        return jugador;
    }

    public JugadorDTO convertirJugadorEntityADTO(Jugador jugador) {

        JugadorDTO jugadorDto = new JugadorDTO();

        jugadorDto.setNombre(jugador.getNombre());
        jugadorDto.setApellido(jugador.getApellido());
        jugadorDto.setDni(jugador.getDni());
        jugadorDto.setTelefono(jugador.getTelefono());
        jugadorDto.setEmail(jugador.getEmail());
        jugadorDto.setFechaDebut(jugador.getFechaDebut());
        jugadorDto.setFechaNacimiento(jugador.getFechaNacimiento());
        jugadorDto.setFechaRetiro(jugador.getFechaRetiro());
        jugadorDto.setCantidadPartidos(jugador.getCantidadPartidos());
        jugadorDto.setCantidadGoles(jugador.getCantidadGoles());
        jugadorDto.setPeso(jugador.getPeso());
        jugadorDto.setAltura(jugador.getAltura());
        jugadorDto.setEquipo(jugador.getEquipo());
        jugadorDto.setHistoriales(jugador.getHistoriales());
        jugadorDto.setDireccion(jugador.getDireccion());

        return jugadorDto;
    }
}
