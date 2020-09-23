package com.ceiba.nomina.infraestructura.adaptador.repositorio;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Pago;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioNomina;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.PagoEntidad;

@Repository
public class RepositorioNominaPostgres implements RepositorioNomina {

    private final RepositorioPagoJpa repositorioPagoJpa;
    private ModelMapper modelMapper = new ModelMapper();

    public RepositorioNominaPostgres(RepositorioPagoJpa repositorioPagoJpa) {
        this.repositorioPagoJpa = repositorioPagoJpa;
    }

    @Override
    public void pagar(Pago pago) {
        PagoEntidad pagoEntidad = modelMapper.map(pago, PagoEntidad.class);
        this.repositorioPagoJpa.save(pagoEntidad);
    }
}
