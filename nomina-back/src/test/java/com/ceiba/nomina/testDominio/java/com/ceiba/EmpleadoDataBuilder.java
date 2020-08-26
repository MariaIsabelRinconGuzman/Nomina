package com.ceiba.nomina.testDominio.java.com.ceiba;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Empleado;

public class EmpleadoDataBuilder {
    private Long idEmpleado;
    private String nombre;
    private Long cargo;

    public EmpleadoDataBuilder() {
        this.idEmpleado = 1036L;
        this.nombre = "Juan Orozco";
        this.cargo = 1L;
    }

    public Empleado build(){
        return new Empleado(this.idEmpleado, this.nombre, this.cargo);
    }
}
