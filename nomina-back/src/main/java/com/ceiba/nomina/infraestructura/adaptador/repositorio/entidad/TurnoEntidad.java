package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.EmpleadoEntidad;

@Entity
@Table(name = "turno")
@Getter
@Setter
public class TurnoEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    @Column
    //@Temporal(TemporalType.TIMESTAMP)
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
