package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.dao;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.EmpleadoDto;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoEmpleado;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.convertidor.ConvertidorListaEmpleado;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.repositoriojpa.RepositorioEmpleadoJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class DaoEmpleadoPostgres implements DaoEmpleado {

    private final RepositorioEmpleadoJpa repositorioEmpleadoJpa;
    private ConvertidorListaEmpleado convertidorListaEmpleado = new ConvertidorListaEmpleado();
    private ModelMapper modelMapper = new ModelMapper();

    public DaoEmpleadoPostgres(RepositorioEmpleadoJpa repositorioEmpleadoJpa) {
        this.repositorioEmpleadoJpa = repositorioEmpleadoJpa;
    }

    @Override
    public List<EmpleadoDto> consultar() {
        return convertidorListaEmpleado.convertirListaEmpleadoEntidadAListaEmpleado(repositorioEmpleadoJpa.consultarEmpleados(), new ArrayList<>());
    }
}
