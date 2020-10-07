package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.configuracion;

import com.ceiba.nomina.dominio.servicio.ServicioListarEmpleados;
import com.ceiba.nomina.dominio.servicio.ServicioListarHorario;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioNomina;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoEmpleado;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoSalario;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoFecha;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.servicio.ServicioCrearTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.servicio.ServicioPagarNomina;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearTurno servicioCrearTurno(DaoTurno daoTurno, RepositorioTurno repositorioTurno) {
		return new ServicioCrearTurno(daoTurno, repositorioTurno);
	}

	@Bean
	public ServicioPagarNomina servicioPagarNomina(DaoEmpleado daoEmpleado, DaoTurno daoTurno, RepositorioNomina repositorioNomina, DaoFecha daoFecha) {
		return new ServicioPagarNomina(daoEmpleado, daoTurno, repositorioNomina, daoFecha);
	}

	@Bean
	public ServicioListarEmpleados servicioListarEmpleados(DaoEmpleado daoEmpleado, DaoSalario daoSalario){
		return new ServicioListarEmpleados(daoEmpleado, daoSalario);
	}

	@Bean
	public ServicioListarHorario servicioListarHorario(DaoTurno daoTurno){
		return new ServicioListarHorario(daoTurno);
	}
}
