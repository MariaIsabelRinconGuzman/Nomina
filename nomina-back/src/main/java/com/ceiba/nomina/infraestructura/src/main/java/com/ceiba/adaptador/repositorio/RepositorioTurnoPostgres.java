package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Turno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioTurno;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.TurnoEntidad;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.repositoriojpa.RepositorioTurnoJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioTurnoPostgres implements RepositorioTurno {

    private final RepositorioTurnoJpa repositorioTurnoJpa;
    private ModelMapper modelMapper = new ModelMapper();

    public RepositorioTurnoPostgres(RepositorioTurnoJpa repositorioTurnoJpa) {
        this.repositorioTurnoJpa = repositorioTurnoJpa;
    }

    @Override
    public void crear(Turno turno) {
        TurnoEntidad turnoEntidad = modelMapper.map(turno, TurnoEntidad.class);
        this.repositorioTurnoJpa.save(turnoEntidad);
    }
}
