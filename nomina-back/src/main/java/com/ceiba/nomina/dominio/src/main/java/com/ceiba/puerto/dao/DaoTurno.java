package com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao;

public interface DaoTurno {

    int consultarDiasLaborados(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin);

    int consultarNochesLaboradas(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
