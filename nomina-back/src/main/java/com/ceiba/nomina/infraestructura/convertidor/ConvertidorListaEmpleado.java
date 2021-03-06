package com.ceiba.nomina.infraestructura.convertidor;

import com.ceiba.nomina.dominio.modelo.dto.EmpleadoDto;
import com.ceiba.nomina.dominio.modelo.dto.SalarioDto;
import com.ceiba.nomina.infraestructura.adaptador.repositorio.entidad.EmpleadoEntidad;
import com.ceiba.nomina.infraestructura.adaptador.repositorio.entidad.SalarioEntidad;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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
