package com.ceiba.nomina.infraestructura.controlador;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.TurnoDto;
import com.ceiba.nomina.aplicacion.comando.manejador.ManejadorListarHorario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/horario")
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
