package com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.SalarioDto;

public interface DaoSalario {

    SalarioDto consultar(Long idEmpleado);
}
