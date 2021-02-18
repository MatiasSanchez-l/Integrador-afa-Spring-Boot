package controller;

import DTOs.JugadorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.JugadorService;
import services.JugadorServiceImpl;


@RestController
@RequestMapping("/jugador")
public class JugadorController{

    @Autowired
    JugadorService adicionalService = new JugadorServiceImpl();

    @GetMapping("/")
    public JugadorDTO getJugador(
            @RequestParam(name = "id") int idJugador
    ) {
        return adicionalService.consultarJugador(idJugador);
    }

    @PostMapping("/guardar")
    public void postJugador(
            @RequestBody JugadorDTO jugadorDTO) {
        adicionalService.insertarJugador(jugadorDTO);
    }

    @PutMapping("/modificar")
    public void putJugador(@RequestBody Integer idJugador,
                          @RequestBody JugadorDTO jugadorDTO) {
        adicionalService.modificarJugador(idJugador, jugadorDTO);
    }

    @DeleteMapping("/borrar")
    public void deleteJugador(@RequestBody Integer idJugador) {
        adicionalService.eliminarJugador(idJugador);
    }

}
