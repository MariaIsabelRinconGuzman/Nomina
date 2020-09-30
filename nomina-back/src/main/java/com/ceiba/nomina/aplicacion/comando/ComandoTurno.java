package com.ceiba.nomina.aplicacion.src.main.java.com.ceiba.comando;

import lombok.*;
import java.time.LocalDateTime;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Empleado;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComandoTurno {
    private Empleado empleado;
    private LocalDateTime fecha;
}
