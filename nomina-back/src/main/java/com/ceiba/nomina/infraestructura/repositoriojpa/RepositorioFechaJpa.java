package com.ceiba.nomina.infraestructura.repositoriojpa;

import com.ceiba.nomina.infraestructura.adaptador.repositorio.entidad.FechaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.time.LocalDate;

@Repository
public interface RepositorioFechaJpa extends JpaRepository<FechaEntidad, Serializable> {

    @Query("Select count(f.id) from FechaEntidad f where f.fecha between :fechaInicio and :fechaFin")
    int consultarDiaFestivo(LocalDate fechaInicio, LocalDate fechaFin);

}
