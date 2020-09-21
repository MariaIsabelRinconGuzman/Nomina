package com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Turno {
    private Long id;
    private Empleado empleado;
    private LocalDateTime fecha;
}