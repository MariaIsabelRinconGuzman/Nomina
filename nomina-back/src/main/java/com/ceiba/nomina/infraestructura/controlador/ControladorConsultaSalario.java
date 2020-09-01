package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.controlador;

import com.ceiba.nomina.aplicacion.src.main.java.com.ceiba.comando.manejador.ManejadorConsultarSalario;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.SalarioDto;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Salario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/salario")
public class ControladorConsultaSalario {

    private final ManejadorConsultarSalario manejadorConsultarSalario;

    public ControladorConsultaSalario(ManejadorConsultarSalario manejadorConsultarSalario) {
        this.manejadorConsultarSalario = manejadorConsultarSalario;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public SalarioDto consultarSalario(@RequestParam int idEmpleado){
        return this.manejadorConsultarSalario.ejecutar(idEmpleado);
    }
}
