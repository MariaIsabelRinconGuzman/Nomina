package com.ceiba.nomina.aplicacion.src.main.java.com.ceiba.comando.fabrica;

import com.ceiba.nomina.aplicacion.src.main.java.com.ceiba.comando.ComandoTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Turno;
import org.springframework.stereotype.Component;

@Component
public class FabricaTurno {

    public Turno crear(ComandoTurno comandoTurno){
        return new Turno(comandoTurno.getEmpleado(), comandoTurno.getFecha());
    }
}
