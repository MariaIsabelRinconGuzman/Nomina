package com.ceiba.nomina.infraestructura.repositoriojpa;

import com.ceiba.nomina.infraestructura.adaptador.repositorio.entidad.TurnoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.time.LocalDateTime;

@Repository
public interface RepositorioTurnoJpa extends JpaRepository<TurnoEntidad, Serializable> {

    @Query("SELECT COUNT(T.id) FROM TurnoEntidad T, EmpleadoEntidad e WHERE T.fecha between :fechaInicio and :fechaFin AND " +
            "e.idEmpleado = :idEmpleado")
    int consultarEmpleadosTurno(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin);

    @Query("Select count(t.id) from TurnoEntidad t where t.fecha between :fechaInicio and :fechaFin")
    int consultar(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    @Query("Select count(t.id) from TurnoEntidad t, EmpleadoEntidad e where e.idEmpleado = :idEmpleado and t.fecha between :fechaInicio and :fechaFin" +
            " and extract(hour from t.fecha) < 18")
    int consultarDiasLaborados(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin);

    @Query("Select count(t.id) from TurnoEntidad t, EmpleadoEntidad e where e.idEmpleado = :idEmpleado and t.fecha between :fechaInicio and :fechaFin" +
            " and extract(hour from t.fecha) >= 18")
    int consultarNochesLaboradas(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
