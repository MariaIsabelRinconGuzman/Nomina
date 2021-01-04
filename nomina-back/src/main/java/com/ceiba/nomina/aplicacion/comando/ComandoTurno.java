package com.ceiba.nomina.aplicacion.comando;

import lombok.*;
import java.time.LocalDateTime;
import com.ceiba.nomina.dominio.modelo.entidad.Empleado;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComandoTurno {
    private Empleado empleado;
    private LocalDateTime fecha;
}
