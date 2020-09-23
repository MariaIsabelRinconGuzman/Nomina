package com.ceiba.nomina.testDominio.java.com.ceiba;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Empleado;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Turno;

import java.time.LocalDateTime;

public class TurnoDataBuilder {
    private Long id;
    private Empleado empleado;
    private LocalDateTime fecha;

    public TurnoDataBuilder() {
        this.id = 1L;
        empleado = new EmpleadoDataBuilder().build();
        this.fecha = LocalDateTime.now();
    }

    public TurnoDataBuilder conFecha(LocalDateTime fecha){
        this.fecha = fecha;
        return this;
    }

    public Turno build(){
        return new Turno(this.id, this.empleado, this.fecha);
    }
}
