package com.ceiba.nomina.aplicacion.comando.manejador;

import com.ceiba.nomina.dominio.servicio.ServicioListarHorario;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.TurnoDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarHorario {

    private ServicioListarHorario servicioListarHorario;

    public ManejadorListarHorario(ServicioListarHorario servicioListarHorario) {
        this.servicioListarHorario = servicioListarHorario;
    }

    public List<TurnoDto> ejecutar(){
        return servicioListarHorario.ejecutar();
    }
}
