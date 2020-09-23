package com.ceiba.nomina.testDominio.java.com.ceiba;

import java.util.List;
import java.util.ArrayList;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.EmpleadoDto;

public class ListaEmpleadoDataBuilder {

    public static List<EmpleadoDto> listaEmpleados(){
        List<EmpleadoDto> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new EmpleadoDtoDataBuilder().build());
        return listaEmpleados;
    }
}
