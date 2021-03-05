package services.servicesImpl;


import DTOs.EquipoDTO;
import entities.Equipo;
import exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EquipoRepository;
import services.EquipoService;

import java.util.ArrayList;
import java.util.List;


@Service
public class EquipoServiceImpl implements EquipoService {
    @Autowired
    EquipoRepository equipoRepository;

    @Override
    public void insertarEquipo(EquipoDTO equipoDTO) throws ServiceException {
        try{
            Equipo equipo = convertirEquipoDtoAEntity(equipoDTO);
            equipoRepository.save(equipo);
        }catch (Exception e){
            throw new ServiceException("DireccionService Error: Error en insertar " + e.getCause());
        }
    }

    @Override
    public void eliminarEquipo(Integer idEquipo) throws ServiceException {
        try{
            equipoRepository.deleteById(idEquipo);
        }catch (Exception e){
            throw new ServiceException("DireccionService Error: Error en eliminar " + e.getCause());
        }
    }

    @Override
    public void modificarEquipo(Integer idEquipo, EquipoDTO equipoDTO) throws ServiceException {
        try{
            Equipo equipo = convertirEquipoDtoAEntity(equipoDTO);
            equipo.setId(idEquipo);
            equipoRepository.save(equipo);
        }catch (Exception e){
            throw new ServiceException("DireccionService Error: Error en modificar " + e.getCause());
        }
    }

    @Override
    public List<EquipoDTO> consultarEquipo(Integer idEquipo) throws ServiceException {
        try{
            Iterable <Equipo> equipos = equipoRepository.findAll();
            List<EquipoDTO> equiposDTO = new ArrayList<>();
            for (Equipo equipo:equipos) {
                EquipoDTO equipoDTO = convertirEquipoEntityADTO(equipo);
                equiposDTO.add(equipoDTO);
            }
            return equiposDTO;
        }catch (Exception e){
            throw new ServiceException("DireccionService Error: Error en consultar " + e.getCause());
        }
    }

    public Equipo convertirEquipoDtoAEntity(EquipoDTO equipoDto) {

        Equipo equipo = new Equipo();
        equipo.setCuit(equipoDto.getCuit());
        equipo.setNombre(equipoDto.getNombre());
        equipo.setFechaFundacion(equipoDto.getFechaFundacion());
        equipo.setPresidenteNombreApellido(equipoDto.getPresidenteNombreApellido());
        equipo.setTelefono(equipoDto.getTelefono());
        equipo.setEmail(equipoDto.getEmail());
        equipo.setFechaPrimeraDivision(equipoDto.getFechaPrimeraDivision());
        equipo.setCategoria(equipoDto.getCategoria());
        equipo.setListaJugadores(equipoDto.getListaJugadores());
        equipo.setDireccion(equipoDto.getDireccion());
        equipo.setHistoriales(equipoDto.getHistoriales());

        return equipo;
    }

    public EquipoDTO convertirEquipoEntityADTO(Equipo equipo) {

        EquipoDTO equipoDto = new EquipoDTO();
        equipoDto.setCuit(equipo.getCuit());
        equipoDto.setNombre(equipo.getNombre());
        equipoDto.setFechaFundacion(equipo.getFechaFundacion());
        equipoDto.setPresidenteNombreApellido(equipo.getPresidenteNombreApellido());
        equipoDto.setTelefono(equipo.getTelefono());
        equipoDto.setEmail(equipo.getEmail());
        equipoDto.setFechaPrimeraDivision(equipo.getFechaPrimeraDivision());
        equipoDto.setCategoria(equipo.getCategoria());
        equipoDto.setListaJugadores(equipo.getListaJugadores());
        equipoDto.setDireccion(equipo.getDireccion());
        equipoDto.setHistoriales(equipo.getHistoriales());

        return equipoDto;
    }


}
