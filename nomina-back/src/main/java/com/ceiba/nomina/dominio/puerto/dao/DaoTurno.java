package com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao;

import java.time.LocalDateTime;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.TurnoDto;

import java.util.List;

public interface DaoTurno {

    List<TurnoDto> listar();

    int consultar(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    int consultarDiasLaborados(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin);

    int consultarNochesLaboradas(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin);

    int consultarEmpleadosTurno(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
