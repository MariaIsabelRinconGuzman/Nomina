package com.ceiba.nomina.dominio.puerto.dao;

import java.time.LocalDate;

public interface DaoFecha {

    int consultarDiaFestivo(LocalDate fechaInicio, LocalDate fechaFin);
}
