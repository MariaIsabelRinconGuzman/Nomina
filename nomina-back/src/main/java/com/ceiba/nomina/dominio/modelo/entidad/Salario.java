package com.ceiba.nomina.dominio.modelo.entidad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
public class Salario {
    private Long idSalario;
    private String cargo;
    private int salarioBase;
    private int salarioRecargo;

    public Salario() {
    }
}