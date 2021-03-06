package com.ceiba.nomina.infraestructura.repositoriojpa;

import com.ceiba.nomina.infraestructura.adaptador.repositorio.entidad.SalarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface RepositorioSalarioJpa extends JpaRepository<SalarioEntidad, Serializable> {

    @Query("select s.salarioTotal from PagoEntidad s, EmpleadoEntidad e where e.idEmpleado = :idEmpleado" )
    int consultarSalarioEmpleado(Long idEmpleado);
}
