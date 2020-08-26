package com.ceiba.nomina.infraestructura.src.main.java.com.ceiba.configuracion;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.servicio.ServicioCrearTurno;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearTurno servicioCrearTurno(RepositorioTurno repositorioTurno) {
		return new ServicioCrearTurno(repositorioTurno);
	}
}
