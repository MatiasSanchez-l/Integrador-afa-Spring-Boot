package controller;

import DTOs.EquipoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.EquipoService;
import services.EquipoServiceImpl;


@RestController
@RequestMapping("/equipo")
public class EquipoController{
    @Autowired
    EquipoService equipoServicio = new EquipoServiceImpl();

    @GetMapping("/")
    public EquipoDTO getEquipo(
            @RequestParam(name = "id") int idEquipo
    ) {
        return equipoServicio.consultarEquipo(idEquipo);
    }

    @PostMapping("/guardar")
    public void postEquipo(
            @RequestBody EquipoDTO equipoDTO) {
        equipoServicio.insertarEquipo(equipoDTO);
    }

    @PutMapping("/modificar")
    public void putEquipo(@RequestBody Integer idEquipo,
                             @RequestBody EquipoDTO equipoDTO) {
        equipoServicio.modificarEquipo(idEquipo, equipoDTO);
    }

    @DeleteMapping("/borrar")
    public void deleteEquipo(@RequestBody Integer idEquipo) {
        equipoServicio.eliminarEquipo(idEquipo);
    }
}
