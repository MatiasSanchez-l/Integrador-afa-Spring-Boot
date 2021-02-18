package services;


import DTOs.EquipoDTO;

import entities.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EquipoRepository;


@Service
public class EquipoServiceImpl implements EquipoService {
    @Autowired
    EquipoRepository equipoRepository;

    @Override
    public void insertarEquipo(EquipoDTO equipoDTO) {
        Equipo equipo = convertirEquipoDtoAEntity(equipoDTO);
        equipoRepository.save(equipo);
    }

    @Override
    public void eliminarEquipo(Integer idEquipo) {
        equipoRepository.deleteById(idEquipo);
    }

    @Override
    public void modificarEquipo(Integer idEquipo, EquipoDTO equipoDTO) {
        Equipo equipo = convertirEquipoDtoAEntity(equipoDTO);
        equipo.setId(idEquipo);
        equipoRepository.save(equipo);

    }

    @Override
    public EquipoDTO consultarEquipo(Integer idEquipo) {
        Equipo equipo = equipoRepository.findById(idEquipo).get();
        EquipoDTO equipoDTO = convertirEquipoEntityADTO(equipo);
        return equipoDTO;
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
