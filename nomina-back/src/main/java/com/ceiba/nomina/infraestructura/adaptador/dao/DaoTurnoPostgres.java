package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.dao;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.EmpleadoDto;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoEmpleado;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoTurno;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.convertidor.ConvertidorListaEmpleado;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.repositoriojpa.RepositorioEmpleadoJpa;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.repositoriojpa.RepositorioTurnoJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class DaoTurnoPostgres implements DaoTurno {

    private final RepositorioTurnoJpa repositorioTurnoJpa;

    public DaoTurnoPostgres(RepositorioTurnoJpa repositorioTurnoJpa) {
        this.repositorioTurnoJpa = repositorioTurnoJpa;
    }

    @Override
    public int consultar(LocalDateTime fecha) {
        return repositorioTurnoJpa.consultar(fecha);
    }

    @Override
    public int consultarDiasLaborados(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return repositorioTurnoJpa.consultarDiasLaborados(idEmpleado, fechaInicio, fechaFin);
    }

    @Override
    public int consultarNochesLaboradas(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return repositorioTurnoJpa.consultarDiasLaborados(idEmpleado, fechaInicio, fechaFin);
    }
}
