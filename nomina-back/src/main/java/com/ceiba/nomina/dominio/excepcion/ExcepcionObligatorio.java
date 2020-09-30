package com.ceiba.nomina.dominio.excepcion;

public class ExcepcionObligatorio extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionObligatorio(String mensaje){
        super(mensaje);
    }
}
