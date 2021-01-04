package com.ceiba.nomina.aplicacion.comando.manejador;

import com.ceiba.nomina.dominio.servicio.ServicioPagarNomina;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
import java.time.LocalDateTime;

@Component
public class ManejadorPagarNomina {

    private ServicioPagarNomina servicioPagarNomina;

    public ManejadorPagarNomina(ServicioPagarNomina servicioPagarNomina) {
        this.servicioPagarNomina = servicioPagarNomina;
    }

    @Scheduled(cron = "0 30 01 * * ?")
    public void ejecutar(){
        servicioPagarNomina.ejecutar(LocalDateTime.now());
    }
}
