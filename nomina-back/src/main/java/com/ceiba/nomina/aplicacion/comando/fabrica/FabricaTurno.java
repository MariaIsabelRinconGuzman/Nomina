package com.ceiba.nomina.aplicacion.comando.fabrica;

import com.ceiba.nomina.aplicacion.comando.ComandoTurno;
import com.ceiba.nomina.dominio.modelo.entidad.Turno;
import org.springframework.stereotype.Component;

@Component
public class FabricaTurno {

    public Turno crear(ComandoTurno comandoTurno){
        return new Turno(comandoTurno.getEmpleado(), comandoTurno.getFecha());
    }
}
