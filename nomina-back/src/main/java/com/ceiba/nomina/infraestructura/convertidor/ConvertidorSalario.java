package com.ceiba.nomina.infraestructura.convertidor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.ceiba.nomina.infraestructura.adaptador.repositorio.entidad.SalarioEntidad;
import com.ceiba.nomina.dominio.modelo.dto.SalarioDto;

@Component
public class ConvertidorSalario {

    private ModelMapper modelMapper = new ModelMapper();

    public SalarioDto convertirSalarioDominioaEntidad(SalarioEntidad salario){
        return modelMapper.map(salario, SalarioDto.class);
    }
}
