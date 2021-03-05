package controller;

import DTOs.JugadorDTO;
import exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.JugadorService;
import services.servicesImpl.JugadorServiceImpl;

import javax.servlet.ServletException;
import java.util.List;


@RestController
@RequestMapping("/jugador")
public class JugadorController{

    @Autowired
    JugadorService adicionalService = new JugadorServiceImpl();

    @GetMapping("/")
    public List<JugadorDTO> getJugador(
            @RequestParam(name = "id") int idJugador
    ) throws ServletException {
        try {
            return adicionalService.consultarJugador(idJugador);
        }catch (ServiceException e){
            throw new ServletException("Servlet Error: Error en get " + e.getCause());
        }

    }

    @PostMapping("/")
    public void postJugador(
            @RequestBody JugadorDTO jugadorDTO) throws ServletException {
        try {
            adicionalService.insertarJugador(jugadorDTO);
        }catch (ServiceException e){
            throw new ServletException("Servlet Error: Error en post " + e.getCause());
        }

    }

    @PutMapping("/")
    public void putJugador(@RequestBody Integer idJugador,
                          @RequestBody JugadorDTO jugadorDTO) throws ServletException {
        try {
            adicionalService.modificarJugador(idJugador, jugadorDTO);
        }catch (ServiceException e){
            throw new ServletException("Servlet Error: Error en put " + e.getCause());
        }
    }

    @DeleteMapping("/")
    public void deleteJugador(@RequestBody Integer idJugador) throws ServletException {

        try {
            adicionalService.eliminarJugador(idJugador);
        }catch (ServiceException e){
            throw new ServletException("Servlet Error: Error en delete " + e.getCause());
        }
    }

}
