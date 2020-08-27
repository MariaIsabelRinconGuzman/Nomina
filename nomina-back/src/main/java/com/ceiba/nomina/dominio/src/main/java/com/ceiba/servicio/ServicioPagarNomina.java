package com.ceiba.nomina.dominio.src.main.java.com.ceiba.servicio;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.EmpleadoDto;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Empleado;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Pago;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Turno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoEmpleado;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoFecha;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioNomina;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioTurno;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public void ejecutar(){
        LocalDate fechaPrimerPago = new LocalDateTime(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(),
                15);
        LocalDate fechaSegundoPago = new LocalDateTime(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(),
                LocalDateTime.now().getMonthValue() == 2 ? 28 : 30);
        if(LocalDate.now().equals(fechaPrimerPago)){
            LocalDateTime diaInicialQuincena = obtenerDiaInicialQuincena();
            realizarPago(obtenerFechaPago(), diaInicialQuincena, fechaPrimerPago);
        }else if(LocalDate.now().equals(fechaSegundoPago)){
            LocalDateTime diaInicialQuincena = new LocalDateTime(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), 15);
            realizarPago(obtenerFechaPago(), diaInicialQuincena, fechaSegundoPago);
        }
    }
    
    private boolean esFestivo(LocalDate fecha){
        return daoFecha.consultarDiaFestivo(fecha.minusDays(1), fecha.plusDays(1)) == 0 ? false : true;
    }

    private LocalDateTime obtenerFechaPago(){
        if(esFestivo(LocalDate.now())){
            if(esFestivo(LocalDate.now().plusDays(1))){
                return LocalDateTime.now().plusDays(2);
            }else{
                return LocalDateTime.now().plusDays(1);
            }
        }
        return LocalDateTime.now();
    }

    private void realizarPago(LocalDateTime fechaPago, LocalDateTime diaInicialQuincena, LocalDateTime diaFinalQuincena){
        List<EmpleadoDto> empleados = daoEmpleado.consultar();
        for (EmpleadoDto empleado: empleados) {
            int diasLaborados = daoTurno.consultarDiasLaborados(empleado.getIdEmpleado(), diaInicialQuincena, diaFinalQuincena);
            int nochesLaboradas = daoTurno.consultarNochesLaboradas(empleado.getIdEmpleado(), diaInicialQuincena, diaFinalQuincena);
            Pago pago = new Pago(null, empleado.getIdEmpleado(), fechaPago,
                    calcularSalario(empleado, diasLaborados, nochesLaboradas), diasLaborados, nochesLaboradas);
            repositorioNomina.pagar(pago);
        }
    }

    private int calcularSalario(EmpleadoDto empleadoDto, int diasLaborados, int nochesLaboradas){
        return (diasLaborados * empleadoDto.getValorDia()) + (nochesLaboradas * empleadoDto.getValorNoche());
    }

    private LocalDateTime obtenerDiaInicialQuincena(){
        int dia = LocalDate.now().minusMonths(1).lengthOfMonth() <= 29 ? 28 : 30;
        return new LocalDateTime(LocalDate.now().getYear(), LocalDate.now().getMonthValue() - 1, dia);
    }
}
