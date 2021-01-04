package com.ceiba.nomina.dominio.modelo.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
public class PagoDto {
    private Long id;
    private Long idEmpleado;
    private LocalDate fecha;
    private int salario;
    private int turnoDia;
    private int turnoNoche;
}
