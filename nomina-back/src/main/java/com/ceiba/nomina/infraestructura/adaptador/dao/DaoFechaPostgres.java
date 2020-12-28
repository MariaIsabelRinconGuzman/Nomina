package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.dao;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoFecha;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.repositoriojpa.RepositorioFechaJpa;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class DaoFechaPostgres implements DaoFecha {

    private final RepositorioFechaJpa repositorioFechaJpa;

    public DaoFechaPostgres(RepositorioFechaJpa repositorioFechaJpa) {
        this.repositorioFechaJpa = repositorioFechaJpa;
    }

    @Override
    public int consultarDiaFestivo(LocalDate fechaInicio, LocalDate fechaFin) {
        return repositorioFechaJpa.consultarDiaFestivo(fechaInicio, fechaFin);
    }
}
