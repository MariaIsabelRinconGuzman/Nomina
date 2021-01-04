package com.ceiba.nomina.dominio.puerto.dao;

import com.ceiba.nomina.dominio.modelo.dto.EmpleadoDto;

import java.util.List;

public interface DaoEmpleado {

    List<EmpleadoDto> consultar();
}
