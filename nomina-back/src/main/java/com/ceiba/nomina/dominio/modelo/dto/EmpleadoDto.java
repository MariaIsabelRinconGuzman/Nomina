package com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto;

import com.ceiba.nomina.dominio.modelo.entidad.Salario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmpleadoDto {
    private Long idEmpleado;
    private String nombre;
    private SalarioDto salario;

    public EmpleadoDto() {
    }
}
