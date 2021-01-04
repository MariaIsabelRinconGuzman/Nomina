package com.ceiba.nomina.dominio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class TurnoDto {
    private Long id;
    private Long idEmpleado;
    private LocalDateTime fecha;

    public TurnoDto() {
    }
}
