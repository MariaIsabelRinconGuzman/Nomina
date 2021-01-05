package com.ceiba.nomina.testDominio.java.com.ceiba;

import com.ceiba.nomina.dominio.excepcion.ExcepcionNegocio;
import com.ceiba.nomina.dominio.modelo.entidad.Turno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.ceiba.nomina.dominio.servicio.ServicioCrearTurno;
import com.ceiba.nomina.dominio.puerto.repositorio.RepositorioTurno;
import com.ceiba.nomina.dominio.puerto.dao.DaoTurno;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class ServicioCrearTurnoTest {

    private ServicioCrearTurno servicioCrearTurno;
    private DaoTurno daoTurno;
    private RepositorioTurno repositorioTurno;

    @BeforeEach
    public void crear() {
        daoTurno = Mockito.mock(DaoTurno.class);
        repositorioTurno = Mockito.mock(RepositorioTurno.class);
        servicioCrearTurno = new ServicioCrearTurno(daoTurno, repositorioTurno);
    }

    @Test
    public void ejecutar() throws ExcepcionNegocio {
        TurnoDataBuilder turnoDataBuilder = new TurnoDataBuilder();
        LocalDateTime fecha = LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(),
                1, 0, 0);
        Turno turno = turnoDataBuilder.conFecha(fecha).build();
        servicioCrearTurno.ejecutar(turno);
        Assertions.assertEquals(turno.getEmpleado().getNombre(), "Juan Orozco");
    }

    @Test
    public void ejecutarExcepcion() throws Exception{
        TurnoDataBuilder turnoDataBuilder = new TurnoDataBuilder();
        Turno turno = turnoDataBuilder.build();
        Assertions.assertThrows(Exception.class, () -> {
            servicioCrearTurno.ejecutar(turno);
        });
    }
}
