package com.ceiba.nomina.dominio.src.main.java.com.ceiba.servicio;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.SalarioDto;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoSalario;

public class ServicioConsultarSalario {

    private final DaoSalario daoSalario;

    public ServicioConsultarSalario(DaoSalario daoSalario) {
        this.daoSalario = daoSalario;
    }

    public SalarioDto ejecutar(Long idEmpleado){
        return daoSalario.consultar(idEmpleado);
    }
}
