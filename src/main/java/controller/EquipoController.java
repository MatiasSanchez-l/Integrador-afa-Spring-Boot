package controller;

import DTOs.EquipoDTO;
import exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.EquipoService;
import services.servicesImpl.EquipoServiceImpl;

import javax.servlet.ServletException;
import java.util.List;


@RestController
@RequestMapping("/equipo")
public class EquipoController{
    @Autowired
    EquipoService equipoServicio = new EquipoServiceImpl();

    @GetMapping("/")
    public List<EquipoDTO> getEquipo() throws ServletException {
        try {
            return equipoServicio.consultarEquipo();
        }catch (ServiceException e){
            throw new ServletException("Servlet Error: Error en get " + e.getCause());
        }
    }

    @PostMapping("/")
    public void postEquipo(
            @RequestBody EquipoDTO equipoDTO) throws ServletException {
        try {
            equipoServicio.insertarEquipo(equipoDTO);
        }catch (ServiceException e){
            throw new ServletException("Servlet Error: Error en post " + e.getCause());
        }
    }

    @PutMapping("/")
    public void putEquipo(@RequestBody Integer idEquipo,
                             @RequestBody EquipoDTO equipoDTO) throws ServletException {
        try {
            equipoServicio.modificarEquipo(idEquipo, equipoDTO);
        }catch (ServiceException e){
            throw new ServletException("Servlet Error: Error en put " + e.getCause());
        }

    }

    @DeleteMapping("/")
    public void deleteEquipo(@RequestBody Integer idEquipo) throws ServletException {

        try {
            equipoServicio.eliminarEquipo(idEquipo);
        }catch (ServiceException e){
            throw new ServletException("Servlet Error: Error en delete " + e.getCause());
        }
    }
}
