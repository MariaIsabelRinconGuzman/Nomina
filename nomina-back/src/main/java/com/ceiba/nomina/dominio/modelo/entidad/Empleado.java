package com.ceiba.nomina.dominio.modelo.entidad;

import com.ceiba.nomina.dominio.excepcion.ExcepcionObligatorio;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Empleado {

    private static final String EL_CAMPO_DEBE_SER_OBLIGATORIO="El campo debe de ser obligatorio";

    private Long idEmpleado;
    private String nombre;
    private Salario salario;

    public Empleado(Long idEmpleado, String nombre, Salario salario) {
        validarCampoObligatorio(idEmpleado, EL_CAMPO_DEBE_SER_OBLIGATORIO);
        validarCampoObligatorio(nombre, EL_CAMPO_DEBE_SER_OBLIGATORIO);

        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.salario = salario;
    }

    public static void validarCampoObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionObligatorio(mensaje);
        }
    }
}
