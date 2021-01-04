package com.ceiba.nomina.infraestructura.adaptador.dao;

import com.ceiba.nomina.infraestructura.repositoriojpa.RepositorioSalarioJpa;
import org.springframework.stereotype.Repository;
import com.ceiba.nomina.dominio.puerto.dao.DaoSalario;

@Repository
public class DaoSalarioPostgres implements DaoSalario{

    private RepositorioSalarioJpa repositorioSalarioJpa;

    public DaoSalarioPostgres(RepositorioSalarioJpa repositorioSalarioJpa) {
        this.repositorioSalarioJpa = repositorioSalarioJpa;
    }

    @Override
    public int consultar(Long idEmpleado) {
        return repositorioSalarioJpa.consultarSalarioEmpleado(idEmpleado);
    }
}
