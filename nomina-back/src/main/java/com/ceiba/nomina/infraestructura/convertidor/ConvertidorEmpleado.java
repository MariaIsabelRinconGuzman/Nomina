package com.ceiba.nomina.infraestructura.convertidor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.ceiba.nomina.dominio.modelo.entidad.Empleado;
import com.ceiba.nomina.infraestructura.adaptador.repositorio.entidad.EmpleadoEntidad;

@Component
public class ConvertidorEmpleado {

    private ModelMapper modelMapper = new ModelMapper();

    public EmpleadoEntidad convertirEmpleadoDominioaEntidad(Empleado empleado){
        return modelMapper.map(empleado, EmpleadoEntidad.class);
    }
}
