package com.ceiba.nomina.infraestructura.convertidor;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.EmpleadoDto;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.EmpleadoEntidad;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.SalarioEntidad;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.SalarioDto;

import java.util.List;

@Component
public class ConvertidorSalario {

    private ModelMapper modelMapper = new ModelMapper();

    public SalarioDto convertirSalarioDominioaEntidad(SalarioEntidad salario){
        return modelMapper.map(salario, SalarioDto.class);
    }
}
