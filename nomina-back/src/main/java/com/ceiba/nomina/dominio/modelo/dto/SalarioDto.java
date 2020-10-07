package com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SalarioDto {
    private Long idSalario;
    private String cargo;
    private int salarioBase;
    private int salarioRecargo;

    public SalarioDto() {
    }
}
