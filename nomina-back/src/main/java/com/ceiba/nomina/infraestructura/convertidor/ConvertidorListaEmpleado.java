package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.convertidor;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.EmpleadoDto;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.EmpleadoEntidad;
import org.modelmapper.ModelMapper;
import java.util.List;

public class ConvertidorListaEmpleado {

    private ModelMapper modelMapper = new ModelMapper();

    public List<EmpleadoDto> convertirListaEmpleadoEntidadAListaEmpleado(List<EmpleadoEntidad> empleadoEntidadLista, List<EmpleadoDto> empleadoDtoLista){
        for (EmpleadoEntidad empleadoEntidad : empleadoEntidadLista) {
            EmpleadoDto empleadoDto = modelMapper.map(empleadoEntidad, EmpleadoDto.class);
            empleadoDtoLista.add(empleadoDto);
        }
        return empleadoDtoLista;
    }
}
