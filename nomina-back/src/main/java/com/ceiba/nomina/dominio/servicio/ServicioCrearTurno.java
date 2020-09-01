package com.ceiba.nomina.dominio.src.main.java.com.ceiba.servicio;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Turno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioTurno;

public class ServicioCrearTurno {

    private final RepositorioTurno repositorioTurno;

    public ServicioCrearTurno(RepositorioTurno repositorioTurno) {
        this.repositorioTurno = repositorioTurno;
    }

    public void ejecutar(Turno turno){
       repositorioTurno.crear(turno);
    }
}
