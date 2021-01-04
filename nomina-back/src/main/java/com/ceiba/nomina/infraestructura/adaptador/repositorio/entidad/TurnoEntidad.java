package com.ceiba.nomina.infraestructura.adaptador.repositorio.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "turno")
@Getter
@Setter
public class TurnoEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    @Column
    private LocalDateTime fecha;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empleado")
    private EmpleadoEntidad empleadoEntidad;

    public TurnoEntidad() {
    }

    public TurnoEntidad(LocalDateTime fecha, EmpleadoEntidad empleadoEntidad) {
        this.fecha = fecha;
        this.empleadoEntidad = empleadoEntidad;
    }
}
