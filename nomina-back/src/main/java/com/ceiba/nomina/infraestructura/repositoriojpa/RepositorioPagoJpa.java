package com.ceiba.nomina.infraestructura.repositoriojpa;

import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.PagoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface RepositorioPagoJpa extends JpaRepository<PagoEntidad, Serializable> {
}
