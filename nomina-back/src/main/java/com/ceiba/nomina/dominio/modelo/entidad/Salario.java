package com.ceiba.nomina.dominio.modelo.entidad;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Salario {
    private Long idSalario;
    private String cargo;
    private int salarioBase;
    private int salarioRecargo;

    public Salario() {
    }

    public Salario(Long idSalario, String cargo, int salarioBase, int salarioRecargo) {
        this.idSalario = idSalario;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.salarioRecargo = salarioRecargo;
    }
}