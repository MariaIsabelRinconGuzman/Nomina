package com.ceiba.nomina.testDominio.java.com.ceiba;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Turno;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class ServicioCrearTurnoTest {

    @Test
    public void ejecutar(){
        TurnoDataBuilder turnoDataBuilder = new TurnoDataBuilder();

        Turno turno = turnoDataBuilder.build();

        Assert.assertEquals(turno.getEmpleado().getNombre(), "Juan Orozco");
    }
}
