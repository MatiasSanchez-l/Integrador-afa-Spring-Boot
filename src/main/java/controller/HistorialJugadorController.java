package controller;

import DTOs.HistorialJugadorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.HistorialJugadorService;
import services.HistorialJugadorServiceImpl;

@RestController
@RequestMapping("/historial")
public class HistorialJugadorController{
    @Autowired
    HistorialJugadorService historialService = new HistorialJugadorServiceImpl();

    @GetMapping("/")
    public HistorialJugadorDTO getHistorial(
            @RequestParam(name = "id") int idHistorial
    ) {
        return historialService.consultarHistorial(idHistorial);
    }

    @PostMapping("/guardar")
    public void postHistorial(
            @RequestBody HistorialJugadorDTO historialDTO) {
        historialService.insertarHistorial(historialDTO);
    }

    @PutMapping("/modificar")
    public void putHistorial(@RequestBody Integer idHistorial,
                           @RequestBody HistorialJugadorDTO historialJugadorDTO) {
        historialService.modificarHistorial(idHistorial, historialJugadorDTO);
    }

    @DeleteMapping("/borrar")
    public void deleteHistorial(@RequestBody Integer idHistorial) {
        historialService.eliminarHistorial(idHistorial);
    }
}
