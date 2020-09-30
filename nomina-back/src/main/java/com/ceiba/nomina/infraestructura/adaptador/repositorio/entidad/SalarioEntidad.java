package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad;

import lombok.AllArgsConstructor;
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

    public SalarioEntidad(Long idSalario, String cargo, int salarioBase, int salarioRecargo) {
        this.idSalario = idSalario;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.salarioRecargo = salarioRecargo;
    }

    public SalarioEntidad() {
    }
}
