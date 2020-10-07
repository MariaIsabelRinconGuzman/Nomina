package com.ceiba.nomina.dominio.servicio;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoEmpleado;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoSalario;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.EmpleadoDto;

import java.util.List;
import java.util.ArrayList;

public class ServicioListarEmpleados {

    private final DaoEmpleado daoEmpleado;
    private final DaoSalario daoSalario;

    public ServicioListarEmpleados(DaoEmpleado daoEmpleado, DaoSalario daoSalario) {
        this.daoEmpleado = daoEmpleado;
        this.daoSalario = daoSalario;
    }

    public List<EmpleadoDto> ejecutar(){
        List<EmpleadoDto> empleados = daoEmpleado.consultar();
        List<EmpleadoDto> empleadosConPago = new ArrayList<>();
        for (EmpleadoDto empleado : empleados) {
            empleado.setUltimoPago(daoSalario.consultar(empleado.getIdEmpleado()));
            empleadosConPago.add(empleado);
        }
        return empleadosConPago;
    }
}
