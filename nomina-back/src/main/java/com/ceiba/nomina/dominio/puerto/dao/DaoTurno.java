package com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao;

import java.time.LocalDateTime;

public interface DaoTurno {

    int consultar(LocalDateTime fecha);

    int consultarDiasLaborados(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin);

    int consultarNochesLaboradas(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
