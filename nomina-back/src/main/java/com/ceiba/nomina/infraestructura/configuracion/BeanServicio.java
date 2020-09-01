package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.configuracion;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioSalario;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioNomina;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoEmpleado;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoFecha;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.servicio.ServicioCrearTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.servicio.ServicioConsultarSalario;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.servicio.ServicioPagarNomina;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearTurno servicioCrearTurno(RepositorioTurno repositorioTurno) {
		return new ServicioCrearTurno(repositorioTurno);
	}

	@Bean
	public ServicioConsultarSalario servicioConsultarSalario(RepositorioSalario repositorioSalario){
		return new ServicioConsultarSalario(repositorioSalario);
	}

	@Bean
	public ServicioPagarNomina servicioPagarNomina(DaoEmpleado daoEmpleado, DaoTurno daoTurno, RepositorioNomina repositorioNomina, DaoFecha daoFecha) {
		return new ServicioPagarNomina(daoEmpleado, daoTurno, repositorioNomina, daoFecha);
	}
}
