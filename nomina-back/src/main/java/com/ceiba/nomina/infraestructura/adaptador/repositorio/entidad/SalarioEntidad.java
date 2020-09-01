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
@AllArgsConstructor
public class SalarioEntidad  implements Serializable {
    @Id
    private Long idSalario;
    @Column
    private String cargo;
    @Column
    private int salarioBase;
    @Column
    private int salarioRecargo;
}
