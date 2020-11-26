package com.ceiba.nomina.testInfraestructura.java.com.ceiba;
import com.ceiba.nomina.aplicacion.src.main.java.com.ceiba.comando.ComandoTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Empleado;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Turno;
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
