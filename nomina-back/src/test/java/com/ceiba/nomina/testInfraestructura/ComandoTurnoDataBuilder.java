package com.ceiba.nomina.testInfraestructura;
import com.ceiba.nomina.aplicacion.comando.ComandoTurno;
import com.ceiba.nomina.dominio.modelo.entidad.Empleado;
import com.ceiba.nomina.dominio.modelo.entidad.Turno;
import com.ceiba.nomina.testDominio.java.com.ceiba.EmpleadoDataBuilder;

import java.time.LocalDateTime;

public class ComandoTurnoDataBuilder {
    private Empleado empleado;
    private LocalDateTime fecha;

    public ComandoTurnoDataBuilder() {
        empleado = new EmpleadoDataBuilder().build();
        this.fecha = LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(),
                1, 0, 0);
    }

    public ComandoTurno build(){
        return new ComandoTurno(this.empleado, this.fecha);
    }
}
