package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.controlador;

import com.ceiba.nomina.aplicacion.src.main.java.com.ceiba.comando.ComandoTurno;
import com.ceiba.nomina.aplicacion.src.main.java.com.ceiba.comando.manejador.ManejadorCrearTurno;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/turno")
public class ControladorComandoTurno {

    private final ManejadorCrearTurno manejadorCrearTurno;

    public ControladorComandoTurno(ManejadorCrearTurno manejadorCrearTurno) {
        this.manejadorCrearTurno = manejadorCrearTurno;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void crearTurno(@RequestBody ComandoTurno comandoTurno) throws Exception{
        this.manejadorCrearTurno.ejecutar(comandoTurno);
    }
}
