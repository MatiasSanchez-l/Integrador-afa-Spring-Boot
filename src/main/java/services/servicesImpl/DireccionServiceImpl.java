package services.servicesImpl;

import DTOs.DireccionDTO;
import entities.Direccion;
import entities.Equipo;
import entities.Persona;
import exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DireccionRepository;
import services.DireccionService;

import java.util.ArrayList;
import java.util.List;

@Service
public class DireccionServiceImpl implements DireccionService {
    @Autowired
    DireccionRepository direccionRepository;

    @Override
    public void insertarDireccion(DireccionDTO direccionDTO) throws ServiceException {
        try {
            Direccion direccion = convertirDireccionDtoAEntity(direccionDTO);
            direccionRepository.save(direccion);
        }catch (Exception e){
            throw new ServiceException("DireccionService Error: Error en insert " + e.getCause());
        }

    }

    @Override
    public void eliminarDireccion(Integer idDireccion) throws ServiceException {
        try {
            direccionRepository.deleteById(idDireccion);
        }catch (Exception e){
            throw new ServiceException("DireccionService Error: Error en eleminar " + e.getCause());
        }

    }

    @Override
    public void modificarDireccion(Integer idDireccion, DireccionDTO direccionDTO) throws ServiceException {
        try{
            Direccion direccion = convertirDireccionDtoAEntity(direccionDTO);
            direccion.setId(idDireccion);
            direccionRepository.save(direccion);
        }catch (Exception e){
            throw new ServiceException("DireccionService Error: Error en modificar " + e.getCause());
        }

    }

    @Override
    public List<DireccionDTO> consultarDireccion(Integer idDireccion) throws ServiceException {
        try{
            Iterable <Direccion> direcciones = direccionRepository.findAll();
            List<DireccionDTO> direccionesDto = new ArrayList<>();
            for (Direccion direccion:direcciones) {
                DireccionDTO direccionDto = convertirDireccionEntityADto(direccion);
                direccionesDto.add(direccionDto);
            }

            return direccionesDto;
        }catch (Exception e){
            throw new ServiceException("DireccionService Error: Error en consultar " + e.getCause());
        }
    }

    public Direccion convertirDireccionDtoAEntity(DireccionDTO direccionDto) {
        String calle = direccionDto.getCalle();
        Integer numero = direccionDto.getNumero();
        String localidad = direccionDto.getLocalidad();
        String provincia = direccionDto.getProvincia();
        Persona persona = direccionDto.getPersona();
        Equipo equipo = direccionDto.getEquipo();

        Direccion direccion = new Direccion();

        direccion.setCalle(calle);
        direccion.setNumero(numero);
        direccion.setLocalidad(localidad);
        direccion.setProvincia(provincia);
        direccion.setPersona(persona);
        direccion.setEquipo(equipo);

        return direccion;
    }

    public DireccionDTO convertirDireccionEntityADto(Direccion direccion) {

        String calle = direccion.getCalle();
        Integer numero = direccion.getNumero();
        String localidad = direccion.getLocalidad();
        String provincia = direccion.getProvincia();
        Persona persona = direccion.getPersona();
        Equipo equipo = direccion.getEquipo();

        DireccionDTO direccionDto = new DireccionDTO();

        direccionDto.setCalle(calle);
        direccionDto.setNumero(numero);
        direccionDto.setLocalidad(localidad);
        direccionDto.setProvincia(provincia);
        direccionDto.setEquipo(equipo);
        direccionDto.setPersona(persona);

        return direccionDto;
    }
}
