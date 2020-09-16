package com.ceiba.nomina.aplicacion.src.main.java.com.ceiba.comando.manejador;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.SalarioDto;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.servicio.ServicioConsultarSalario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultarSalario {

    private ServicioConsultarSalario servicioConsultarSalario;

    public ManejadorConsultarSalario(ServicioConsultarSalario servicioConsultarSalario) {
        this.servicioConsultarSalario = servicioConsultarSalario;
    }

    public SalarioDto ejecutar(Long idEmpleado){
        return servicioConsultarSalario.ejecutar(idEmpleado);
    }
}
