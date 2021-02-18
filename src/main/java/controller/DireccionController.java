package controller;

import DTOs.DireccionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.DireccionService;
import services.DireccionServiceImpl;


@RestController
@RequestMapping("/direccion")
public class DireccionController{
    @Autowired
    DireccionService direccionService = new DireccionServiceImpl();

    @GetMapping("/")
    public DireccionDTO getDireccion(
            @RequestParam(name = "id") int idDireccion
            ) {
        return direccionService.consultarDireccion(idDireccion);
    }
    @PostMapping("/guardar")
    public void postDireccion(
            @RequestBody DireccionDTO direccionDTO) {
        direccionService.insertarDireccion(direccionDTO);
    }

    @PutMapping("/modificar")
    public void putDireccion(@RequestBody Integer idDireccion,
                             @RequestBody DireccionDTO direccionDTO) {
        direccionService.modificarDireccion(idDireccion, direccionDTO);
    }

    @DeleteMapping("/borrar")
    public void deleteDireccion(@RequestBody Integer idDireccion) {
        direccionService.eliminarDireccion(idDireccion);
    }
}
