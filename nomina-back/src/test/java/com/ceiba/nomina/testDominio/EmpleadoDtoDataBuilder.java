package com.ceiba.nomina.testDominio.java.com.ceiba;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.EmpleadoDto;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.SalarioDto;

public class EmpleadoDtoDataBuilder {
    private Long idEmpleado;
    private String nombre;
    private SalarioDto salarioDto;

    public EmpleadoDtoDataBuilder() {
        this.idEmpleado = 1036L;
        this.nombre = "Juan Orozco";
        this.salarioDto = new SalarioDto();

    }

    public EmpleadoDto build(){
        return new EmpleadoDto(this.idEmpleado, this.nombre, this.salarioDto);
    }
}
