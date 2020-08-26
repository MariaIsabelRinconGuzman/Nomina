package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.SalarioDto;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Salario;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Turno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioSalario;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioTurno;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.SalarioEntidad;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.repositoriojpa.RepositorioSalarioJpa;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.repositoriojpa.RepositorioTurnoJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioSalarioPostgres implements RepositorioSalario {

    private final RepositorioSalarioJpa repositorioSalarioJpa;
    private ModelMapper modelMapper = new ModelMapper();

    public RepositorioSalarioPostgres(RepositorioSalarioJpa repositorioSalarioJpa) {
        this.repositorioSalarioJpa = repositorioSalarioJpa;
    }

    @Override
    public SalarioDto consultar(int idEmpleado) {
        SalarioEntidad salarioEntidad = repositorioSalarioJpa.consultarSalarioEmpleado(idEmpleado);
        return modelMapper.map(salarioEntidad, SalarioDto.class);
    }
}
