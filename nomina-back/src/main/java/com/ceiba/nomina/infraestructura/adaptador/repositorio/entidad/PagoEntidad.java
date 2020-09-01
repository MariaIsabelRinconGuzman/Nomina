package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad;

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
    @GeneratedValue()
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
}
