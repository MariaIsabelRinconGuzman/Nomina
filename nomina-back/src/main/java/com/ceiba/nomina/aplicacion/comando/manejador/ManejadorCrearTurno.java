package com.ceiba.nomina.aplicacion.comando.manejador;

import com.ceiba.nomina.aplicacion.comando.ComandoTurno;
import com.ceiba.nomina.aplicacion.comando.fabrica.FabricaTurno;
import com.ceiba.nomina.dominio.excepcion.ExcepcionNegocio;
import com.ceiba.nomina.dominio.modelo.entidad.Turno;
import com.ceiba.nomina.dominio.servicio.ServicioCrearTurno;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearTurno {

    private ServicioCrearTurno servicioCrearTurno;
    private FabricaTurno fabricaTurno;

    public ManejadorCrearTurno(ServicioCrearTurno servicioCrearTurno, FabricaTurno fabricaTurno) {
        this.servicioCrearTurno = servicioCrearTurno;
        this.fabricaTurno = fabricaTurno;
    }

    public void ejecutar(ComandoTurno comandoTurno) throws ExcepcionNegocio {
        Turno turno = fabricaTurno.crear(comandoTurno);
        servicioCrearTurno.ejecutar(turno);
    }
}
