package com.ceiba.nomina.testInfraestructura;

import com.ceiba.nomina.NominaApplication;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.repositoriojpa.RepositorioTurnoJpa;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.repositoriojpa.RepositorioSalarioJpa;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.repositoriojpa.RepositorioEmpleadoJpa;
import com.ceiba.nomina.aplicacion.src.main.java.com.ceiba.comando.ComandoTurno;
import com.ceiba.nomina.testInfraestructura.java.com.ceiba.ComandoTurnoDataBuilder;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.SalarioEntidad;
import com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.adaptador.repositorio.entidad.EmpleadoEntidad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = NominaApplication.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControladorComandoTurnoTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RepositorioEmpleadoJpa repositorioEmpleadoJpa;
    @Autowired
    private RepositorioSalarioJpa repositorioSalarioJpa;
    @Autowired
    private RepositorioTurnoJpa repositorioTurnoJpa;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void crearTurno() throws Exception{
        SalarioEntidad salarioEntidad = new SalarioEntidad(1L, "Operario", 100, 200);
        repositorioSalarioJpa.save(salarioEntidad);

        EmpleadoEntidad empleadoEntidad = new EmpleadoEntidad(1036L, "Juan Orozco", salarioEntidad);
        repositorioEmpleadoJpa.save(empleadoEntidad);

        ComandoTurno comandoTurno = new ComandoTurnoDataBuilder().build();
        mockMvc.perform(post("http://localhost:8090/turno")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoTurno))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
