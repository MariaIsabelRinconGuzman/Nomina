package com.ceiba.nomina.testDominio;

import com.ceiba.nomina.dominio.servicio.ServicioListarEmpleados;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoEmpleado;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoSalario;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.EmpleadoDto;
import com.ceiba.nomina.testDominio.java.com.ceiba.ListaEmpleadoDtoDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class ServicioListarEmpleadosTest {

    private ServicioListarEmpleados servicioListarEmpleados;
    private DaoEmpleado daoEmpleado;
    private DaoSalario daoSalario;

    @BeforeEach
    public void crear() {
        daoEmpleado = Mockito.mock(DaoEmpleado.class);
        daoSalario = Mockito.mock(DaoSalario.class);
        servicioListarEmpleados = new ServicioListarEmpleados(daoEmpleado, daoSalario);
    }

    @Test
    public void ejecutar(){
        ListaEmpleadoDtoDataBuilder listaEmpleadoDtoDataBuilder = new com.ceiba.nomina.testDominio.java.com.ceiba.ListaEmpleadoDtoDataBuilder();
        List<EmpleadoDto> empleados = listaEmpleadoDtoDataBuilder.listaEmpleados();
        servicioListarEmpleados.ejecutar();
        Assertions.assertEquals(empleados.size(), 1);
    }
}
