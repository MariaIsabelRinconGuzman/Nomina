package com.ceiba.nomina.infraestructura.adaptador.repositorio.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "salario")
@Getter
@Setter
public class SalarioEntidad  implements Serializable {
    @Id
    private Long idSalario;
    @Column
    private String cargo;
    @Column
    private int salarioBase;
    @Column
    private int salarioRecargo;


    public SalarioEntidad() {
    }

    public SalarioEntidad(Long idSalario, String cargo, int salarioBase, int salarioRecargo) {
        this.idSalario = idSalario;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.salarioRecargo = salarioRecargo;
    }
}
