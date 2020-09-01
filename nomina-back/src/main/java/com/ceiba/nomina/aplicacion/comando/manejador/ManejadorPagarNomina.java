package com.ceiba.nomina.aplicacion.src.main.java.com.ceiba.comando.manejador;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.servicio.ServicioPagarNomina;
import org.springframework.stereotype.Component;

@Component
public class ManejadorPagarNomina {

    private ServicioPagarNomina servicioPagarNomina;

    public ManejadorPagarNomina(ServicioPagarNomina servicioPagarNomina) {
        this.servicioPagarNomina = servicioPagarNomina;
    }

    public void ejecutar(){
        servicioPagarNomina.ejecutar();
    }
}
