package controller;

import DTOs.DireccionDTO;
import exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.DireccionService;
import services.servicesImpl.DireccionServiceImpl;

import javax.servlet.ServletException;
import java.util.List;


@RestController
@RequestMapping("/direccion")
public class DireccionController{
    @Autowired
    DireccionService direccionService = new DireccionServiceImpl();

    @GetMapping("/")
    public List<DireccionDTO> getDireccion(
            ) throws ServletException {
        try {
            return direccionService.consultarDireccion();
        }catch (ServiceException e){
            throw new ServletException("Servlet Error: Error en get " + e.getCause());
        }
    }
    @PostMapping("/")
    public void postDireccion(
            @RequestBody DireccionDTO direccionDTO) throws ServletException {
        try {
            direccionService.insertarDireccion(direccionDTO);
        }catch (ServiceException e){
            throw new ServletException("Servlet Error: Error en post " + e.getCause());
        }
    }

    @PutMapping("/")
    public void putDireccion(@RequestBody Integer idDireccion,
                             @RequestBody DireccionDTO direccionDTO) throws ServletException {
        try {
            direccionService.modificarDireccion(idDireccion, direccionDTO);
        }catch (ServiceException e){
            throw new ServletException("Servlet Error: Error en put " + e.getCause());
        }

    }

    @DeleteMapping("/")
    public void deleteDireccion(@RequestBody Integer idDireccion) throws ServletException {
        try {
            direccionService.eliminarDireccion(idDireccion);
        }catch (ServiceException e){
            throw new ServletException("Servlet Error: Error en delete " + e.getCause());
        }

    }
}
