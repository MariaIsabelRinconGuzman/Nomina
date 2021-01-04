package com.ceiba.nomina.infraestructura.adaptador.repositorio.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "festivos")
@Getter
@Setter
@AllArgsConstructor
public class FechaEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @Column
    private LocalDate fecha;
}
