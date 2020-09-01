package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad;

import lombok.AllArgsConstructor;
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
    @Id
    @GeneratedValue()
    private Long id;
    @Column
    private LocalDateTime fecha;
    @ManyToOne()
    @JoinColumn(name = "id_empleado")
    private EmpleadoEntidad empleadoEntidad;


}
