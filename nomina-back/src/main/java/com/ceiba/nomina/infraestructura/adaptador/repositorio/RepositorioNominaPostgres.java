package com.ceiba.nomina.infraestructura.adaptador.repositorio;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import com.ceiba.nomina.dominio.modelo.entidad.Pago;
import com.ceiba.nomina.dominio.puerto.repositorio.RepositorioNomina;
import com.ceiba.nomina.infraestructura.adaptador.repositorio.entidad.PagoEntidad;
import com.ceiba.nomina.infraestructura.repositoriojpa.RepositorioPagoJpa;

@Repository
public class RepositorioNominaPostgres implements RepositorioNomina {

    private ModelMapper modelMapper = new ModelMapper();
    private final RepositorioPagoJpa repositorioPagoJpa;

    public RepositorioNominaPostgres(RepositorioPagoJpa repositorioPagoJpa) {
        this.repositorioPagoJpa = repositorioPagoJpa;
    }

    @Override
    public void pagar(Pago pago) {
        PagoEntidad pagoEntidad = modelMapper.map(pago, PagoEntidad.class);
        this.repositorioPagoJpa.save(pagoEntidad);
    }
}
