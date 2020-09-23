package com.ceiba.nomina.infraestructura.repositoriojpa;

import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.PagoEntidad;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPagoJpa extends JpaRepository<PagoEntidad, Serializable> {

}
