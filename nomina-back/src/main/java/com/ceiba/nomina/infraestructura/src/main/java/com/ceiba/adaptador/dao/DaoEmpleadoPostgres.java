package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.dao;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.EmpleadoDto;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.SalarioDto;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoEmpleado;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioSalario;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.convertidor.ConvertidorListaEmpleado;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.repositoriojpa.RepositorioEmpleadoJpa;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.repositoriojpa.RepositorioSalarioJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoEmpleadoPostgres implements DaoEmpleado {

    private final RepositorioEmpleadoJpa repositorioSalarioJpa;
    private ConvertidorListaEmpleado convertidorListaEmpleado;
    private ModelMapper modelMapper = new ModelMapper();

    public DaoEmpleadoPostgres(RepositorioEmpleadoJpa repositorioSalarioJpa) {
        this.repositorioSalarioJpa = repositorioSalarioJpa;
    }

    @Override
    public List<EmpleadoDto> consultar() {
        return convertidorListaEmpleado.convertirListaEmpleadoEntidadAListaEmpleado(repositorioEmpleadoJpa.consultarEmpleados(), new ArrayList<>());
    }
}
