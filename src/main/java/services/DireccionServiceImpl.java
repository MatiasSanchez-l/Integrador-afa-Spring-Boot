package services;

import DTOs.DireccionDTO;
import entities.Direccion;
import entities.Equipo;
import entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DireccionRepository;

@Service
public class DireccionServiceImpl implements DireccionService{
    @Autowired
    DireccionRepository direccionRepository;

    @Override
    public void insertarDireccion(DireccionDTO direccionDTO) {
        Direccion direccion = convertirDireccionDtoAEntity(direccionDTO);
        direccionRepository.save(direccion);
    }

    @Override
    public void eliminarDireccion(Integer idDireccion) {
        direccionRepository.deleteById(idDireccion);
    }

    @Override
    public void modificarDireccion(Integer idDireccion, DireccionDTO direccionDTO) {
        Direccion direccion = convertirDireccionDtoAEntity(direccionDTO);
        direccion.setId(idDireccion);
        direccionRepository.save(direccion);
    }

    @Override
    public DireccionDTO consultarDireccion(Integer idDireccion) {
        Direccion direccion = direccionRepository.findById(idDireccion).get();
        DireccionDTO direccionDto = convertirDireccionEntityADto(direccion);
        return direccionDto;
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
