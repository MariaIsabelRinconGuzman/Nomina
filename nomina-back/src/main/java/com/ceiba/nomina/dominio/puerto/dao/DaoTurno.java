package com.ceiba.nomina.dominio.puerto.dao;

import java.time.LocalDateTime;
import com.ceiba.nomina.dominio.modelo.dto.TurnoDto;

import java.util.List;

public interface DaoTurno {

    List<TurnoDto> listar();

    int consultar(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    int consultarDiasLaborados(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin);

    int consultarNochesLaboradas(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin);

    int consultarEmpleadosTurno(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
