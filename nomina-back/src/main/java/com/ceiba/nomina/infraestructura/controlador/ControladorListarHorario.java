package com.ceiba.nomina.infraestructura.controlador;

import com.ceiba.nomina.dominio.modelo.dto.TurnoDto;
import com.ceiba.nomina.aplicacion.comando.manejador.ManejadorListarHorario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/horario")
@CrossOrigin
public class ControladorListarHorario {

    private final ManejadorListarHorario manejadorListarHorario;

    public ControladorListarHorario(ManejadorListarHorario manejadorListarHorario) {
        this.manejadorListarHorario = manejadorListarHorario;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TurnoDto> listarEmpleados(){
        return this.manejadorListarHorario.ejecutar();
    }
}
