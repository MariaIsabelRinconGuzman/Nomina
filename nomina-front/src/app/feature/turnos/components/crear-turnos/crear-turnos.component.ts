import { Component, OnInit, ViewChild } from '@angular/core';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormGroup, FormControl } from '@angular/forms';
import { TurnosService } from '../../shared/service/turnos.service';
import { ListarEmpleadosService } from 'src/app/feature/shared/service/listar-empleados.service';
import { Turno } from '../../shared/model/turno';
import { Empleado } from 'src/app/feature/shared/model/empleado';
import { FullCalendarComponent, CalendarOptions } from '@fullcalendar/angular'; // useful for typechecking
import Swal from 'sweetalert2';

@Component({
  selector: 'app-crear-turnos',
  templateUrl: './crear-turnos.component.html',
  styleUrls: ['./crear-turnos.component.sass']
})
export class CrearTurnosComponent implements OnInit {
/* lista de empleados y turnos que viene de bd */
  empleados=[];
  turnos=[];
  form:FormGroup;
  empleado : Empleado;

  @ViewChild('calendar') calendarComponent: FullCalendarComponent;

  calendarOptions: CalendarOptions = {
    initialView: 'dayGridMonth',
    weekends: false // initial value
  };

  constructor(config: NgbModalConfig, private modalService: NgbModal, 
    private turnosService:TurnosService,
    private listarEmpleadosService: ListarEmpleadosService) {
    config.backdrop = 'static';
    config.keyboard = false;
  }

  ngOnInit(): void {
    this.listarEmpleados();
    this.listarTurnos();
    this.formulario();
    
  }
  public formulario(){
    this.form = new FormGroup({
      fecha: new FormControl(''),
      empleado: new FormControl('')
    });
  } 

  public open(content): void {
    this.modalService.open(content);
  }

  public agregarTurno(){
    
    console.log(this.form.value);
    console.log(this.form.value.fecha);

    const body: Turno = {
   empleado:this.buscarEmpleado(this.form.value.empleado),
   fecha:this.form.value.fecha
    }
  
    this.turnosService.agregarTurno(body).subscribe(respuesta => {
      console.log(respuesta);
      Swal.fire({
        title: 'Se ha creado el turno correctamente',
        position: 'center',
        icon: 'success',       
        showConfirmButton: true,
      });
    }, (error) => Swal.fire({
      title: error.error.message,
      position: 'center',
      icon: 'error',       
      showConfirmButton: true,
    }));

    this.listarEmpleados();
  }

  public listarTurnos(){
    console.log(this.turnosService.listarTurnos())
    this.turnosService.listarTurnos().
    subscribe((data) => {
      if (data) {
        data.forEach(turno => {
          turno.empleado = this.buscarEmpleado(turno.idEmpleado);
          this.turnos.push(turno);
        });
      }
    });
    console.log(this.turnos);
  }

  public listarEmpleados(){
    this.listarEmpleadosService.listarEmpleados().
      subscribe((data) => {
        if (data) {
          this.empleados = data;
        }
      });
    console.log(this.empleados);
  }

  public buscarEmpleado(idEmpleado){
    return this.empleados.find(empleado1 => empleado1.idEmpleado == idEmpleado);
  }

}
