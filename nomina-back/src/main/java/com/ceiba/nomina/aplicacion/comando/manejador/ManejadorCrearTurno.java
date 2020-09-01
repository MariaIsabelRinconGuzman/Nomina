package com.ceiba.nomina.aplicacion.src.main.java.com.ceiba.comando.manejador;

import com.ceiba.nomina.aplicacion.src.main.java.com.ceiba.comando.ComandoTurno;
import com.ceiba.nomina.aplicacion.src.main.java.com.ceiba.comando.fabrica.FabricaTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Turno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.servicio.ServicioCrearTurno;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearTurno {

    private ServicioCrearTurno servicioCrearTurno;
    private FabricaTurno fabricaTurno;

    public ManejadorCrearTurno(ServicioCrearTurno servicioCrearTurno, FabricaTurno fabricaTurno) {
        this.servicioCrearTurno = servicioCrearTurno;
        this.fabricaTurno = fabricaTurno;
    }

    public void ejecutar(ComandoTurno comandoTurno){
        Turno turno = fabricaTurno.crear(comandoTurno);
        servicioCrearTurno.ejecutar(turno);
    }
}
