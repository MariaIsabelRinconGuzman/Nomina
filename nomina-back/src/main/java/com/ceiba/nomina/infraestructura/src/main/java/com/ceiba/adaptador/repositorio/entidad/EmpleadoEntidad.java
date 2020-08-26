package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "empleado")
@Getter
public class EmpleadoEntidad  implements Serializable {
    @Id
    private Long idEmpleado;
    @Column
    private String nombre;
    @OneToOne()
    @JoinColumn(name = "idSalario")
    private SalarioEntidad salarioEntidad;

    public EmpleadoEntidad(Long idEmpleado, String nombre, Long SalarioEntidad salarioEntidad) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.salarioEntidad = salarioEntidad;
    }

    public EmpleadoEntidad() {
    }
}
