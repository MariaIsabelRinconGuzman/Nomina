package com.ceiba.nomina.dominio.servicio;

import com.ceiba.nomina.dominio.excepcion.ExcepcionNegocio;
import com.ceiba.nomina.dominio.modelo.entidad.Turno;
import com.ceiba.nomina.dominio.puerto.repositorio.RepositorioTurno;
import com.ceiba.nomina.dominio.puerto.dao.DaoTurno;
import com.ceiba.nomina.dominio.modelo.entidad.Empleado;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public class ServicioCrearTurno {

    private final DaoTurno daoTurno;
    private final RepositorioTurno repositorioTurno;

    public ServicioCrearTurno(DaoTurno daoTurno, RepositorioTurno repositorioTurno) {
        this.daoTurno = daoTurno;
        this.repositorioTurno = repositorioTurno;
    }

    @Transactional
    public void ejecutar(Turno turno) throws ExcepcionNegocio{
        validarMinimoTrabajadores(turno);
    }

    private void validarMinimoTrabajadores(Turno turno) throws ExcepcionNegocio{
        Empleado empleado = turno.getEmpleado();
        LocalDateTime fechaInicio = LocalDateTime.of(turno.getFecha().getYear(), turno.getFecha().getMonthValue(),
                turno.getFecha().getDayOfMonth(), 0, 0);
        LocalDateTime fechaFin = LocalDateTime.of(turno.getFecha().getYear(), turno.getFecha().getMonthValue(),
                turno.getFecha().getDayOfMonth(), 23, 59);
        if(fechaInicio.getDayOfMonth() > 1){
            int turnos = daoTurno.consultar(fechaInicio.minusDays(1L), fechaFin.minusDays(1L));
            if(turnos < 2){
                throw new ExcepcionNegocio("El turno del día anterior debe tener mínimo dos empleados");
            }else{
                int empleadosTurno = daoTurno.consultarEmpleadosTurno(empleado.getIdEmpleado(), fechaInicio, fechaFin);
                if(empleadosTurno < 1){
                    repositorioTurno.crear(turno);
                }else{
                    throw new ExcepcionNegocio("El empleado solo puede realizar un turno");
                }
            }
        }else{
            repositorioTurno.crear(turno);
        }
    }
}
