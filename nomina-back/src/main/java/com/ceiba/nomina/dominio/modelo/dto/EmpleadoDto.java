package com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmpleadoDto {
    private Long idEmpleado;
    private String nombre;
    private Long cargo;
    private int valorDia;
    private int valorNoche;
}
