package com.ceiba.nomina.dominio.src.main.java.com.ceiba.servicio;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Turno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoTurno;
import java.lang.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ServicioCrearTurno {

    private final DaoTurno daoTurno;
    private final RepositorioTurno repositorioTurno;

    public ServicioCrearTurno(DaoTurno daoTurno, RepositorioTurno repositorioTurno) {
        this.daoTurno = daoTurno;
        this.repositorioTurno = repositorioTurno;
    }

    public void ejecutar(Turno turno){
        validarMinimoTrabajadores(turno.getFecha());
    }

    private void validarMinimoTrabajadores(LocalDateTime fechaTurno){
        if(fechaTurno.minusDays(1L).getDayOfMonth() > 1){
            int turnos = daoTurno.consultar(fechaTurno.minusDays(1L));
            if(turnos < 2){
                throw new Exception("El turno del día anterior debe tener mínimo dos empleados");
            }else{
                repositorioTurno.crear(turno);
            }
        }else{
            repositorioTurno.crear(turno);
        }
    }
}
