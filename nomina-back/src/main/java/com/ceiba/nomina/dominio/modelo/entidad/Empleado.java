package com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Empleado {
    private Long idEmpleado;
    private String nombre;
    private Long cargo;
}
