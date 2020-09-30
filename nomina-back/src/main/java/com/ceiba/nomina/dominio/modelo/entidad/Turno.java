package com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad;

import com.ceiba.nomina.dominio.excepcion.ExcepcionObligatorio;
import com.ceiba.nomina.dominio.excepcion.ExcepcionFechaInvalida;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Turno {

    private static final String EL_CAMPO_DEBE_SER_OBLIGATORIO="El campo debe de ser obligatorio";
    private static final String LA_FECHA_DEL_TURNO_DEBE_SER_FUTURA="La fecha del turno debe ser futura";

    //private Long id;
    private Empleado empleado;
    private LocalDateTime fecha;

    public Turno(Empleado empleado, LocalDateTime fecha) {
       // validarCampoObligatorio(empleado, EL_CAMPO_DEBE_SER_OBLIGATORIO);
        validarFecha(fecha, LA_FECHA_DEL_TURNO_DEBE_SER_FUTURA);

       // this.id = id;
        this.empleado = empleado;
        this.fecha = fecha;
    }

    public static void validarCampoObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionObligatorio(mensaje);
        }
    }

    public static void validarFecha(LocalDateTime fecha, String mensaje) {
        if (fecha.minusDays(1).isAfter(LocalDateTime.now())) {
            throw new ExcepcionFechaInvalida(mensaje);
        }
    }


}