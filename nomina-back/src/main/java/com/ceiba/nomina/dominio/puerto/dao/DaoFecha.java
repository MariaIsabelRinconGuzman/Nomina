package com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.EmpleadoDto;

import java.time.LocalDate;

public interface DaoFecha {

    int consultarDiaFestivo(LocalDate fechaInicio, LocalDate fechaFin);
}
