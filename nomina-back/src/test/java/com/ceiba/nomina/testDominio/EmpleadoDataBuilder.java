package com.ceiba.nomina.testDominio.java.com.ceiba;

import com.ceiba.nomina.dominio.modelo.entidad.Salario;
import com.ceiba.nomina.dominio.modelo.entidad.Empleado;

public class EmpleadoDataBuilder {
    private Long idEmpleado;
    private String nombre;
    private Salario salario;

    public EmpleadoDataBuilder() {
        this.idEmpleado = 1036L;
        this.nombre = "Juan Orozco";
        this.salario = new Salario();
    }

    public Empleado build(){
        return new Empleado(this.idEmpleado, this.nombre, this.salario);
    }
}
