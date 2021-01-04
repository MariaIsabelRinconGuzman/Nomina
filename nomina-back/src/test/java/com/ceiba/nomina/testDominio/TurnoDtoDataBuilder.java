package com.ceiba.nomina.testDominio;

import com.ceiba.nomina.dominio.modelo.dto.TurnoDto;

import java.time.LocalDateTime;

public class TurnoDtoDataBuilder {
    private Long id;
    private Long idEmpleado;
    private LocalDateTime fecha;

    public TurnoDtoDataBuilder() {
        this.id = 1L;
        this.idEmpleado = 1036L;
        this.fecha = LocalDateTime.of(2020, 9, 1, 0, 0);
    }

    public TurnoDto build(){
        return new TurnoDto(this.id, this.idEmpleado, this.fecha);
    }
}
