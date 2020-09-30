package com.ceiba.nomina.infraestructura.convertidor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Empleado;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.EmpleadoEntidad;

@Component
public class ConvertidorEmpleado {

    private ModelMapper modelMapper = new ModelMapper();

    public EmpleadoEntidad convertirEmpleadoDominioaEntidad(Empleado empleado){
        EmpleadoEntidad empleadoEntidad = modelMapper.map(empleado, EmpleadoEntidad.class);
        return empleadoEntidad;
    }
}
