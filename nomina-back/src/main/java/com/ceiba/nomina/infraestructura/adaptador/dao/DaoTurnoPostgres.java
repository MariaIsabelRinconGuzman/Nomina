package com.ceiba.nomina.infraestructura.adaptador.dao;

import com.ceiba.nomina.dominio.puerto.dao.DaoTurno;
import com.ceiba.nomina.infraestructura.convertidor.ConvertidorListaTurno;
import com.ceiba.nomina.infraestructura.repositoriojpa.RepositorioTurnoJpa;
import org.springframework.stereotype.Repository;
import com.ceiba.nomina.dominio.modelo.dto.TurnoDto;
import java.util.List;
import java.util.ArrayList;

import java.time.LocalDateTime;

@Repository
public class DaoTurnoPostgres implements DaoTurno {

    private final RepositorioTurnoJpa repositorioTurnoJpa;
    private ConvertidorListaTurno convertidorListaTurno = new ConvertidorListaTurno();

    public DaoTurnoPostgres(RepositorioTurnoJpa repositorioTurnoJpa) {
        this.repositorioTurnoJpa = repositorioTurnoJpa;
    }

    @Override
    public List<TurnoDto> listar(){
        List<TurnoDto> turnoDtoLista = new ArrayList<>();
        return convertidorListaTurno.convertirListaTurnoEntidadAListaTurno(repositorioTurnoJpa.findAll(), turnoDtoLista);
    }

    @Override
    public int consultar(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return repositorioTurnoJpa.consultar(fechaInicio, fechaFin);
    }

    @Override
    public int consultarDiasLaborados(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return repositorioTurnoJpa.consultarDiasLaborados(idEmpleado, fechaInicio, fechaFin);
    }

    @Override
    public int consultarNochesLaboradas(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return repositorioTurnoJpa.consultarDiasLaborados(idEmpleado, fechaInicio, fechaFin);
    }

    @Override
    public int consultarEmpleadosTurno(Long idEmpleado, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return repositorioTurnoJpa.consultarEmpleadosTurno(idEmpleado, fechaInicio, fechaFin);
    }
}
