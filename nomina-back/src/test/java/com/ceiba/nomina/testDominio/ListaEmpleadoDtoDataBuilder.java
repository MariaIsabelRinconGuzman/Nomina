package com.ceiba.nomina.testDominio.java.com.ceiba;

import java.util.List;
import java.util.ArrayList;
import com.ceiba.nomina.dominio.modelo.dto.EmpleadoDto;

public class ListaEmpleadoDtoDataBuilder {

    public static List<EmpleadoDto> listaEmpleados(){
        List<EmpleadoDto> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new EmpleadoDtoDataBuilder().build());
        return listaEmpleados;
    }
}
