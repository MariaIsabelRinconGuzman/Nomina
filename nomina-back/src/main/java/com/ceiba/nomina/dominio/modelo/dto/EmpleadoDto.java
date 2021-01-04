package com.ceiba.nomina.dominio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmpleadoDto {
    private Long idEmpleado;
    private String nombre;
    private SalarioDto salario;
    private int ultimoPago;

    public EmpleadoDto() {
    }
}
