package com.ceiba.nomina.dominio.src.main.java.com.ceiba.servicio;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.SalarioDto;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioSalario;

public class ServicioConsultarSalario {

    private final RepositorioSalario repositorioSalario;

    public ServicioConsultarSalario(RepositorioSalario repositorioSalario) {
        this.repositorioSalario = repositorioSalario;
    }

    public SalarioDto ejecutar(Long idEmpleado){
        return repositorioSalario.consultar(idEmpleado);
    }
}
