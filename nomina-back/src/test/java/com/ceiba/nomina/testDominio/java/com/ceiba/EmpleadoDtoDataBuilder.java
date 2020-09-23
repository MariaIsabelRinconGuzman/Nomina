package com.ceiba.nomina.testDominio.java.com.ceiba;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.EmpleadoDto;

public class EmpleadoDtoDataBuilder {
    private Long idEmpleado;
    private String nombre;
    private Long cargo;
    private int valorDia;
    private int valorNoche;

    public EmpleadoDtoDataBuilder() {
        this.idEmpleado = 1036L;
        this.nombre = "Juan Orozco";
        this.cargo = 1L;
        this.valorDia = 900000;
        this.valorNoche = 1200000;
    }

    public EmpleadoDto build(){
        return new EmpleadoDto(this.idEmpleado, this.nombre, this.cargo, this.valorDia, this.valorNoche);
    }
}
