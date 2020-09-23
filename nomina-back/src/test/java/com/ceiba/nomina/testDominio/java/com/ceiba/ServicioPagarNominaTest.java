package com.ceiba.nomina.testDominio.java.com.ceiba;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Turno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.servicio.ServicioPagarNomina;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoEmpleado;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioNomina;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoFecha;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDateTime;
import java.util.List;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.EmpleadoDto;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Pago;
import com.ceiba.nomina.testDominio.java.com.ceiba.ListaEmpleadoDataBuilder;

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
        List<EmpleadoDto> empleados = ListaEmpleadoDataBuilder.listaEmpleados();
        Mockito.when(daoEmpleado.consultar()).thenReturn(empleados);
        Mockito.when(daoTurno.consultarDiasLaborados(Mockito.anyLong(), Mockito.any(), Mockito.any())).thenReturn(10);
        Mockito.when(daoTurno.consultarNochesLaboradas(Mockito.anyLong(), Mockito.any(), Mockito.any())).thenReturn(15);
        int cantidadPagos = servicioPagarNomina.ejecutar(fecha);
        Assertions.assertEquals(cantidadPagos, 1);
    }
}
