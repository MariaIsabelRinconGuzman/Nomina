package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.repositoriojpa;

import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.EmpleadoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.io.Serializable;

@Repository
public interface RepositorioEmpleadoJpa extends JpaRepository<EmpleadoEntidad, Serializable> {

    @Query("select e from EmpleadoEntidad e" )
    List<EmpleadoEntidad> consultarEmpleados();

}
