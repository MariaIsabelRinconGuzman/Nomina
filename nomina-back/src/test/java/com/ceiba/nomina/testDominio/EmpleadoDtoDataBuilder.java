package com.ceiba.nomina.testDominio.java.com.ceiba;

import com.ceiba.nomina.dominio.modelo.dto.EmpleadoDto;
import com.ceiba.nomina.dominio.modelo.dto.SalarioDto;

public class EmpleadoDtoDataBuilder {
    private Long idEmpleado;
    private String nombre;
    private SalarioDto salarioDto;
    private int ultimoPago;

    public EmpleadoDtoDataBuilder() {
        this.idEmpleado = 1036L;
        this.nombre = "Juan Orozco";
        this.salarioDto = new SalarioDto();
        this.ultimoPago = 1250000;
    }

    public EmpleadoDto build(){
        return new EmpleadoDto(this.idEmpleado, this.nombre, this.salarioDto, this.ultimoPago);
    }
}
