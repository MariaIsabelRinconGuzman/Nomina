package com.ceiba.nomina.testInfraestructura;

import com.ceiba.nomina.NominaApplication;
import com.ceiba.nomina.infraestructura.repositoriojpa.RepositorioPagoJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.is;
import org.springframework.http.MediaType;

import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.repositoriojpa.RepositorioEmpleadoJpa;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.repositoriojpa.RepositorioSalarioJpa;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.SalarioEntidad;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.EmpleadoEntidad;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.PagoEntidad;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.dao.DaoEmpleadoPostgres;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = NominaApplication.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControladorListarEmpleadosTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RepositorioEmpleadoJpa repositorioEmpleadoJpa;
    @Autowired
    private RepositorioSalarioJpa repositorioSalarioJpa;
    @Autowired
    private RepositorioPagoJpa repositorioPagoJpa;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void listarEmpleados() throws Exception{
        SalarioEntidad salarioEntidad = new SalarioEntidad(1L, "Operario", 100, 200);
        repositorioSalarioJpa.save(salarioEntidad);

        EmpleadoEntidad empleadoEntidad = new EmpleadoEntidad(1L, "Juan Orozco", salarioEntidad);
        repositorioEmpleadoJpa.save(empleadoEntidad);

        PagoEntidad pagoEntidad = new PagoEntidad(LocalDateTime.now(), 100, 20, 5, empleadoEntidad);
        repositorioPagoJpa.save(pagoEntidad);

        DaoEmpleadoPostgres daoEmpleadoPostgres = new DaoEmpleadoPostgres(repositorioEmpleadoJpa);

        mockMvc.perform(get("http://localhost:8090/empleado")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
