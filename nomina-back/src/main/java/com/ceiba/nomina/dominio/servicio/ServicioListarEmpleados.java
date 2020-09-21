package com.ceiba.nomina.dominio.servicio;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoEmpleado;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.EmpleadoDto;

import java.util.List;

public class ServicioListarEmpleados {

    private final DaoEmpleado daoEmpleado;

    public ServicioListarEmpleados(DaoEmpleado daoEmpleado) {
        this.daoEmpleado = daoEmpleado;
    }

    public List<EmpleadoDto> ejecutar(){
        return daoEmpleado.consultar();
    }
}
