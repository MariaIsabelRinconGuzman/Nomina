package com.ceiba.nomina.infraestructura.convertidor;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.TurnoDto;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.TurnoEntidad;
import org.modelmapper.ModelMapper;

import java.util.List;

public class ConvertidorListaTurno {

    private ModelMapper modelMapper = new ModelMapper();

    public List<TurnoDto> convertirListaTurnoEntidadAListaTurno(List<TurnoEntidad> turnoEntidadLista, List<TurnoDto> turnoDtoLista){
        for (TurnoEntidad turnoEntidad : turnoEntidadLista) {
            TurnoDto turnoDto = modelMapper.map(turnoEntidad, TurnoDto.class);
            turnoDtoLista.add(turnoDto);
        }
        return turnoDtoLista;
    }
}
