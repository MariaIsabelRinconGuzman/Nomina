package com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.SalarioDto;

    public interface RepositorioSalario {

    SalarioDto consultar(int idEmpleado);
}
