package com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class TurnoDto {
    private Long id;
    private Long idEmpleado;
    private LocalDate fecha;
}
