package com.ceiba.nomina.aplicacion.src.main.java.com.ceiba.comando;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Empleado;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComandoTurno {
    private Long id;
    private Empleado empleado;
    private LocalDateTime fecha;
}
