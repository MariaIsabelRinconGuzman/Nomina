package com.ceiba.nomina.infraestructura.adaptador.repositorio;

import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.repositoriojpa.RepositorioSalarioJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Pago;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioNomina;

@Repository
public class RepositorioNominaPostgres implements RepositorioNomina {

    private final RepositorioSalarioJpa repositorioSalarioJpa;
    private ModelMapper modelMapper = new ModelMapper();

    public RepositorioNominaPostgres(RepositorioSalarioJpa repositorioSalarioJpa) {
        this.repositorioSalarioJpa = repositorioSalarioJpa;
    }

    @Override
    public void pagar(Pago pago) {

    }
}
