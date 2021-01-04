package com.ceiba.nomina.infraestructura.adaptador.dao;

import com.ceiba.nomina.dominio.modelo.dto.EmpleadoDto;
import com.ceiba.nomina.dominio.puerto.dao.DaoEmpleado;
import com.ceiba.nomina.infraestructura.convertidor.ConvertidorListaEmpleado;
import com.ceiba.nomina.infraestructura.repositoriojpa.RepositorioEmpleadoJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class DaoEmpleadoPostgres implements DaoEmpleado {

    private final RepositorioEmpleadoJpa repositorioEmpleadoJpa;
    private ConvertidorListaEmpleado convertidorListaEmpleado = new ConvertidorListaEmpleado();

    public DaoEmpleadoPostgres(RepositorioEmpleadoJpa repositorioEmpleadoJpa) {
        this.repositorioEmpleadoJpa = repositorioEmpleadoJpa;
    }

    @Override
    public List<EmpleadoDto> consultar() {
        return convertidorListaEmpleado.convertirListaEmpleadoEntidadAListaEmpleado(repositorioEmpleadoJpa.consultarEmpleados(), new ArrayList<>());
    }
}
