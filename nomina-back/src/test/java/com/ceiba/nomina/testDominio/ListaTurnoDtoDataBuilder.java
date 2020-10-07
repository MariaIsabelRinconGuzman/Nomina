package com.ceiba.nomina.testDominio;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.TurnoDto;

import java.util.ArrayList;
import java.util.List;

public class ListaTurnoDtoDataBuilder {

    public static List<TurnoDto> listaTurnos(){
        List<TurnoDto> listaTurnos = new ArrayList<>();
        listaTurnos.add(new TurnoDtoDataBuilder().build());
        return listaTurnos;
    }
}
