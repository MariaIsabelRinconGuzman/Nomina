package com.ceiba.nomina.testDominio;

import com.ceiba.nomina.dominio.servicio.ServicioListarHorario;
import com.ceiba.nomina.dominio.modelo.dto.TurnoDto;
import com.ceiba.nomina.dominio.puerto.dao.DaoTurno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class ServicioListarTurnosTest {

    private ServicioListarHorario servicioListarHorario;
    private DaoTurno daoTurno;

    @BeforeEach
    public void crear() {
        daoTurno = Mockito.mock(DaoTurno.class);
        servicioListarHorario = new ServicioListarHorario(daoTurno);
    }

    @Test
    public void ejecutar(){
        ListaTurnoDtoDataBuilder listaTurnoDtoDataBuilder = new ListaTurnoDtoDataBuilder();
        List<TurnoDto> turnos = listaTurnoDtoDataBuilder.listaTurnos();
        servicioListarHorario.ejecutar();
        Assertions.assertEquals(turnos.size(), 1);
    }
}
