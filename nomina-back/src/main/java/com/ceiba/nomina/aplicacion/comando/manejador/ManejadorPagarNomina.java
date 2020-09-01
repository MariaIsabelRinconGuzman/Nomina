package com.ceiba.nomina.aplicacion.src.main.java.com.ceiba.comando.manejador;

public class ManejadorPagarNomina {

    private ServicioPagarNomina servicioPagarNomina;

    public ManejadorPagarNomina(ServicioPagarNomina servicioPagarNomina) {
        this.servicioPagarNomina = servicioPagarNomina;
    }

    public void ejecutar(){
        servicioPagarNomina.ejecutar();
    }
}
