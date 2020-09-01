package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.repositoriojpa;

import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.TurnoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.time.LocalDateTime;

@Repository
public interface RepositorioTurnoJpa extends JpaRepository<TurnoEntidad, Serializable> {

    @Query("Select count(t.id) from TurnoEntidad t where t.idEmpleado = :idEmpleado and t.fecha between :fechaInicio and :fechaFin" +
            "and extract(hour from t.fecha) < 18")
    int consultarDiasLaborados(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin);

    @Query("Select count(t.id) from TurnoEntidad t where t.idEmpleado = :idEmpleado and t.fecha between :fechaInicio and :fechaFin" +
            "and extract(hour from t.fecha) >= 18")
    int consultarNochesLaboradas(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin);

}
