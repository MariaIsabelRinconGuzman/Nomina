package com.ceiba.nomina.testDominio.java.com.ceiba;

import com.ceiba.nomina.dominio.puerto.dao.DaoTurno;
import com.ceiba.nomina.dominio.servicio.ServicioPagarNomina;
import com.ceiba.nomina.dominio.puerto.dao.DaoEmpleado;
import com.ceiba.nomina.dominio.puerto.repositorio.RepositorioNomina;
import com.ceiba.nomina.dominio.puerto.dao.DaoFecha;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDateTime;
import java.util.List;
import com.ceiba.nomina.dominio.modelo.dto.EmpleadoDto;

public class ServicioPagarNominaTest {

    private ServicioPagarNomina servicioPagarNomina;
    private DaoEmpleado daoEmpleado;
    private DaoTurno daoTurno;
    private RepositorioNomina repositorioNomina;
    private DaoFecha daoFecha;

    @BeforeEach
    public void crear() {
        daoTurno = Mockito.mock(DaoTurno.class);
        daoEmpleado = Mockito.mock(DaoEmpleado.class);
        daoFecha = Mockito.mock(DaoFecha.class);
        repositorioNomina = Mockito.mock(RepositorioNomina.class);
        servicioPagarNomina = new ServicioPagarNomina(daoEmpleado, daoTurno, repositorioNomina, daoFecha);
    }

    @Test
    public void ejecutar(){
        LocalDateTime fecha = LocalDateTime.of(2020, 9, 15, 0, 0);
        List<EmpleadoDto> empleados = com.ceiba.nomina.testDominio.java.com.ceiba.ListaEmpleadoDtoDataBuilder.listaEmpleados();
        Mockito.when(daoEmpleado.consultar()).thenReturn(empleados);
        Mockito.when(daoTurno.consultarDiasLaborados(Mockito.anyLong(), Mockito.any(), Mockito.any())).thenReturn(10);
        Mockito.when(daoTurno.consultarNochesLaboradas(Mockito.anyLong(), Mockito.any(), Mockito.any())).thenReturn(15);
        int cantidadPagos = servicioPagarNomina.ejecutar(fecha);
        Assertions.assertEquals(cantidadPagos, 1);
    }
}
