package com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import com.ceiba.nomina.dominio.excepcion.ExcepcionObligatorio;

@Getter
@Setter
public class Pago {

    private static final String EL_CAMPO_DEBE_SER_OBLIGATORIO="El campo debe de ser obligatorio";

    private Long id;
    private Long idEmpleado;
    private LocalDateTime fecha;
    private int salario;
    private int turnoDia;
    private int turnoNoche;

    public Pago(Long id, Long idEmpleado, LocalDateTime fecha, int salario, int turnoDia, int turnoNoche) {
        validarCampoObligatorio(idEmpleado, EL_CAMPO_DEBE_SER_OBLIGATORIO);
        validarCampoObligatorio(fecha, EL_CAMPO_DEBE_SER_OBLIGATORIO);
        validarCampoObligatorio(salario, EL_CAMPO_DEBE_SER_OBLIGATORIO);
        validarCampoObligatorio(turnoDia, EL_CAMPO_DEBE_SER_OBLIGATORIO);
        validarCampoObligatorio(turnoNoche, EL_CAMPO_DEBE_SER_OBLIGATORIO);

        this.id = id;
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.salario = salario;
        this.turnoDia = turnoDia;
        this.turnoNoche = turnoNoche;
    }

    public static void validarCampoObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionObligatorio(mensaje);
        }
    }
}
