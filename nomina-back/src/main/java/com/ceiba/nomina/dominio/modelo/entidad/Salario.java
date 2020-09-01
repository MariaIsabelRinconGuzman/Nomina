package com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Salario {
    private Long id;
    private String cargo;
    private int salarioBase;
    private int salarioRecargo;
}
