package com.ceiba.nomina.dominio.src.main.java.com.ceiba.servicio;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Turno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Empleado;
import java.time.LocalDateTime;

public class ServicioCrearTurno {

    private final DaoTurno daoTurno;
    private final RepositorioTurno repositorioTurno;

    public ServicioCrearTurno(DaoTurno daoTurno, RepositorioTurno repositorioTurno) {
        this.daoTurno = daoTurno;
        this.repositorioTurno = repositorioTurno;
    }

    public void ejecutar(Turno turno) throws Exception{
        validarMinimoTrabajadores(turno);
    }

    private void validarMinimoTrabajadores(Turno turno) throws Exception{
        Empleado empleado = turno.getEmpleado();
        LocalDateTime fechaInicio = LocalDateTime.of(turno.getFecha().getYear(), turno.getFecha().getMonthValue(),
                turno.getFecha().getDayOfMonth(), 0, 0);
        LocalDateTime fechaFin = LocalDateTime.of(turno.getFecha().getYear(), turno.getFecha().getMonthValue(),
                turno.getFecha().getDayOfMonth(), 23, 59);
   //     LocalDateTime fechaTurno = turno.getFecha();
        if(fechaInicio.getDayOfMonth() > 1){
            int turnos = daoTurno.consultar(fechaInicio.minusDays(1L), fechaFin.minusDays(1L));
            if(turnos < 2){
                throw new Exception("El turno del día anterior debe tener mínimo dos empleados");
            }else{
                int empleadosTurno = daoTurno.consultarEmpleadosTurno(empleado.getIdEmpleado(), fechaInicio, fechaFin);
                if(empleadosTurno < 1){
                    repositorioTurno.crear(turno);
                }else{
                    throw new Exception("El empleado solo puede realizar un turno");
                }
            }
        }else{
            repositorioTurno.crear(turno);
        }
    }
}
