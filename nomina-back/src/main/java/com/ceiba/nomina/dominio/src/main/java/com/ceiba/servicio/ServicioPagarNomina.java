package com.ceiba.nomina.dominio.src.main.java.com.ceiba.servicio;

import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.dto.EmpleadoDto;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Empleado;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Pago;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.modelo.entidad.Turno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoEmpleado;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.dao.DaoTurno;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioNomina;
import com.ceiba.nomina.dominio.src.main.java.com.ceiba.puerto.repositorio.RepositorioTurno;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ServicioPagarNomina {

    private final DaoEmpleado daoEmpleado;
    private final DaoTurno daoTurno;

    public ServicioPagarNomina(DaoEmpleado daoEmpleado, DaoTurno daoTurno) {
        this.daoEmpleado = daoEmpleado;
        this.daoTurno = daoTurno;
    }

    public void ejecutar(){
        LocalDate fechaPrimerPago = new LocalDate(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(),
                15);
        LocalDate fechaSegundoPago = new LocalDate(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(),
                LocalDateTime.now().getMonthValue() == 2 ? 28 : 30);
        if(LocalDate.now().equals(fechaPrimerPago) || LocalDate.now().equals(fechaSegundoPago)){
            realizarPago(obtenerFechaPago(), fechaPrimerPago, fechaSegundoPago);
        }
    }
    
    private boolean esFestivo(LocalDateTime fecha){

        //crear tabla con fechas de festivos

        //consultar tabla
        return false;
    }

    private LocalDateTime obtenerFechaPago(){
        if(esFestivo(LocalDateTime.now())){
            if(esFestivo(LocalDateTime.now().plusDays(1))){
                return LocalDateTime.now().plusDays(2);
            }else{
                return LocalDateTime.now().plusDays(1);
            }
        }
        return LocalDateTime.now();
    }

    private void realizarPago(LocalDateTime fechaPago, LocalDateTime fechaPrimerPago, LocalDateTime fechaSegundoPago){
        List<EmpleadoDto> empleados= daoEmpleado.consultar();
        for (EmpleadoDto empleado: empleados) {
            int diasLaborados = daoTurno.consultarDiasLaborados(empleado.getIdEmpleado());
            int nochesLaboradas = daoTurno.consultarNochesLaboradas(empleado.getIdEmpleado());
            Pago pago = new Pago(null, empleado.getIdEmpleado(), fechaPago,
                    calcularSalario(empleado, diasLaborados, nochesLaboradas), diasLaborados, nochesLaboradas);
            repositorioNomina.pagar(pago);
        }
    }

    private int calcularSalario(EmpleadoDto empleadoDto, int diasLaborados, int nochesLaboradas){
        return (diasLaborados * empleadoDto.getValorDia()) + (nochesLaboradas * empleadoDto.getValorNoche());
    }
}
