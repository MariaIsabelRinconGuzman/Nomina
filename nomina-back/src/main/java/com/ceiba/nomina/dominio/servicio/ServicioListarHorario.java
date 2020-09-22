package com.ceiba.nomina.dominio.servicio;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.TurnoDto;

import java.util.List;

public class ServicioListarHorario {

    private final DaoTurno daoTurno;

    public ServicioListarHorario(DaoTurno daoTurno) {
        this.daoTurno = daoTurno;
    }

    public List<TurnoDto> ejecutar(){
        return daoTurno.listar();
    }
}
