package controller;

import DTOs.HistorialJugadorDTO;
import exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.HistorialJugadorService;
import services.servicesImpl.HistorialJugadorServiceImpl;

import javax.servlet.ServletException;
import java.util.List;

@RestController
@RequestMapping("/historial")
public class HistorialJugadorController{
    @Autowired
    HistorialJugadorService historialService = new HistorialJugadorServiceImpl();

    @GetMapping("/")
    public List<HistorialJugadorDTO> getHistorial(
            @RequestParam(name = "id") int idHistorial
    ) throws ServletException {
        try {
            return historialService.consultarHistorial(idHistorial);
        }catch (ServiceException e){
            throw new ServletException("Servlet Error: Error en get " + e.getCause());
        }

    }

    @PostMapping("/")
    public void postHistorial(
            @RequestBody HistorialJugadorDTO historialDTO) throws ServletException {
        try {
            historialService.insertarHistorial(historialDTO);
        }catch (ServiceException e){
            throw new ServletException("Servlet Error: Error en post " + e.getCause());
        }

    }

    @PutMapping("/")
    public void putHistorial(@RequestBody Integer idHistorial,
                           @RequestBody HistorialJugadorDTO historialJugadorDTO) throws ServletException {
        try {
            historialService.modificarHistorial(idHistorial, historialJugadorDTO);
        }catch (ServiceException e){
            throw new ServletException("Servlet Error: Error en put " + e.getCause());
        }

    }

    @DeleteMapping("/")
    public void deleteHistorial(@RequestBody Integer idHistorial) throws ServletException {

        try {
            historialService.eliminarHistorial(idHistorial);
        }catch (ServiceException e){
            throw new ServletException("Servlet Error: Error en delete " + e.getCause());
        }
    }
}
