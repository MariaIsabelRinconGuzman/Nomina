package com.ceiba.nomina.dominio.modelo.entidad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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