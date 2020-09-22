package com.ceiba.nomina.aplicacion.comando.manejador;

import com.ceiba.nomina.dominio.servicio.ServicioListarEmpleados;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.EmpleadoDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarEmpleados {

    private ServicioListarEmpleados servicioListarEmpleados;

    public ManejadorListarEmpleados(ServicioListarEmpleados servicioListarEmpleados) {
        this.servicioListarEmpleados = servicioListarEmpleados;
    }

    public List<EmpleadoDto> ejecutar(){
        return servicioListarEmpleados.ejecutar();
    }
}
