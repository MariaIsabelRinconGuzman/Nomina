package com.ceiba.nomina.infraestructura.controlador;

import com.ceiba.nomina.aplicacion.comando.manejador.ManejadorListarEmpleados;
import com.ceiba.nomina.dominio.modelo.dto.EmpleadoDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/empleado")
@CrossOrigin
public class ControladorListarEmpleados {

    private final ManejadorListarEmpleados manejadorListarEmpleados;

    public ControladorListarEmpleados(ManejadorListarEmpleados manejadorListarEmpleados) {
        this.manejadorListarEmpleados = manejadorListarEmpleados;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmpleadoDto> listarEmpleados(){
        return this.manejadorListarEmpleados.ejecutar();
    }
}
