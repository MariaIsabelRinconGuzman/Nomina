package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.repositoriojpa;

import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.FechaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface RepositorioFechaJpa extends JpaRepository<FechaEntidad, Serializable> {

    @Query("Select count(f.id) from FechaEntidad f where f.fecha between :fechaInicio and :fechaFin")
    int consultarDiaFestivo(LocalDate fechaInicio, LocalDate fechaFin);

}
