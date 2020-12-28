package com.ceiba.nomina.infraestructura.adaptador.dao;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.SalarioDto;
import com.ceiba.nomina.infraestructura.convertidor.ConvertidorSalario;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.SalarioEntidad;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.repositoriojpa.RepositorioSalarioJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoSalario;

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
