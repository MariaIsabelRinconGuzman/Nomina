package com.ceiba.nomina.testInfraestructura.java.com.ceiba;
import com.ceiba.nomina.aplicacion.src.main.java.com.ceiba.comando.ComandoTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Empleado;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Turno;
import com.ceiba.nomina.testDominio.java.com.ceiba.EmpleadoDataBuilder;

import java.time.LocalDateTime;

public class ComandoTurnoDataBuilder {
    private Long id;
    private Empleado empleado;
    private LocalDateTime fecha;

    public ComandoTurnoDataBuilder() {
        this.id = 1L;
        empleado = new EmpleadoDataBuilder().build();
        this.fecha = LocalDateTime.now();
    }

    public ComandoTurno build(){
        return new ComandoTurno(this.id, this.empleado, this.fecha);
    }
}
