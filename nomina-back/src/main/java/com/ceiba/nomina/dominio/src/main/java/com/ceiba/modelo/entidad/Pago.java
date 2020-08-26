package com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
public class Pago {
    private Long id;
    private Long idEmpleado;
    private LocalDateTime fecha;
    private int salario;
    private int turnoDia;
    private int turnoNoche;
}
