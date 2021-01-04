package com.ceiba.nomina.infraestructura.adaptador.repositorio.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "pago")
@Getter
@Setter
@AllArgsConstructor
public class PagoEntidad  implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    @Column
    private LocalDateTime fecha;
    @Column
    private int salarioTotal;
    @Column
    private int turnoDia;
    @Column
    private int turnoNoche;
    @ManyToOne()
    @JoinColumn(name = "idEmpleado")
    private EmpleadoEntidad empleadoEntidad;

    public PagoEntidad() {
    }

    public PagoEntidad(LocalDateTime fecha, int salarioTotal, int turnoDia, int turnoNoche, EmpleadoEntidad empleadoEntidad) {
        this.fecha = fecha;
        this.salarioTotal = salarioTotal;
        this.turnoDia = turnoDia;
        this.turnoNoche = turnoNoche;
        this.empleadoEntidad = empleadoEntidad;
    }
}
