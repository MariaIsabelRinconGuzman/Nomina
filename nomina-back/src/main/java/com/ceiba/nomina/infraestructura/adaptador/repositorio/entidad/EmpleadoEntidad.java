package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad;

import com.ceiba.nomina.dominio.modelo.entidad.Salario;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.SalarioEntidad;
import lombok.Setter;

@Entity
@Table(name = "empleado")
@Getter
@Setter
public class EmpleadoEntidad{
    @Id
    private Long idEmpleado;
    @Column
    private String nombre;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idSalario")
    private SalarioEntidad salarioEntidad;

    public EmpleadoEntidad() {
    }

    public EmpleadoEntidad(Long idEmpleado, String nombre, SalarioEntidad salarioEntidad) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.salarioEntidad = salarioEntidad;
    }
}
