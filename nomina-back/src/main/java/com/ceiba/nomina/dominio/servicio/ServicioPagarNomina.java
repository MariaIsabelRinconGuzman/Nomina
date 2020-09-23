package com.ceiba.nomina.dominio.src.main.java.com.ceiba.servicio;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.EmpleadoDto;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Pago;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoEmpleado;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoFecha;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioNomina;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;

public class ServicioPagarNomina {

    private final DaoEmpleado daoEmpleado;
    private final DaoTurno daoTurno;
    private final RepositorioNomina repositorioNomina;
    private final DaoFecha daoFecha;

    public ServicioPagarNomina(DaoEmpleado daoEmpleado, DaoTurno daoTurno, RepositorioNomina repositorioNomina, DaoFecha daoFecha) {
        this.daoEmpleado = daoEmpleado;
        this.daoTurno = daoTurno;
        this.repositorioNomina = repositorioNomina;
        this.daoFecha = daoFecha;
    }

    public int ejecutar(LocalDateTime fecha){
        int cantidadPagos = 0;
        LocalDateTime fechaPrimerPago = LocalDateTime.of(fecha.getYear(), fecha.getMonthValue(),
                15, 0, 0);
        LocalDateTime fechaSegundoPago = LocalDateTime.of(fecha.getYear(), fecha.getMonthValue(),
                fecha.getMonthValue() == 2 ? 28 : 30, 0, 0);
        if(fecha.equals(fechaPrimerPago)){
            LocalDateTime diaInicialQuincena = obtenerDiaInicialQuincena(fecha);
            cantidadPagos = realizarPago(obtenerFechaPago(fecha), diaInicialQuincena, fechaPrimerPago);
        }else if(fecha.equals(fechaSegundoPago)){
            LocalDateTime diaInicialQuincena = LocalDateTime.of(fecha.getYear(), fecha.getMonthValue(), 15, 0, 0);
            cantidadPagos = realizarPago(obtenerFechaPago(fecha), diaInicialQuincena, fechaSegundoPago);
        }
        return cantidadPagos;
    }
    
    private boolean esFestivo(LocalDateTime fecha){
        LocalDate fechaNueva = LocalDate.of(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth());
        return daoFecha.consultarDiaFestivo(fechaNueva.minusDays(1), fechaNueva.plusDays(1)) == 0 ? false : true;
    }

    private LocalDateTime obtenerFechaPago(LocalDateTime fecha){
        if(esFestivo(fecha)){
            if(esFestivo(fecha.plusDays(1))){
                return fecha.plusDays(2);
            }else{
                return fecha.plusDays(1);
            }
        }
        return fecha;
    }

    private int realizarPago(LocalDateTime fechaPago, LocalDateTime diaInicialQuincena, LocalDateTime diaFinalQuincena){
        int cantidadPagos = 0;
        List<EmpleadoDto> empleados = daoEmpleado.consultar();
        for (EmpleadoDto empleado: empleados) {
            int diasLaborados = daoTurno.consultarDiasLaborados(empleado.getIdEmpleado(), diaInicialQuincena, diaFinalQuincena);
            int nochesLaboradas = daoTurno.consultarNochesLaboradas(empleado.getIdEmpleado(), diaInicialQuincena, diaFinalQuincena);
            Pago pago = new Pago(null, empleado.getIdEmpleado(), fechaPago,
                    calcularSalario(empleado, diasLaborados, nochesLaboradas), diasLaborados, nochesLaboradas);
            repositorioNomina.pagar(pago);
            cantidadPagos ++;
        }
        return cantidadPagos;
    }

    private int calcularSalario(EmpleadoDto empleadoDto, int diasLaborados, int nochesLaboradas){
        return (diasLaborados * (empleadoDto.getValorDia()/30)) + (nochesLaboradas * (empleadoDto.getValorNoche()/30));
    }

    private LocalDateTime obtenerDiaInicialQuincena(LocalDateTime fecha){
        int dia = fecha.minusMonths(1).getDayOfMonth() <= 29 ? 28 : 30;
        return LocalDateTime.of(fecha.getYear(), fecha.getMonthValue() - 1, dia, 0, 0);
    }
}
