import { Component, OnInit } from '@angular/core';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormGroup, FormControl } from '@angular/forms';
import { TurnosService } from '../../shared/service/turnos.service';
import { ListarEmpleadosService } from 'src/app/feature/shared/service/listar-empleados.service';

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

  constructor(config: NgbModalConfig, private modalService: NgbModal, 
    private turnosService:TurnosService,
    private listarEmpleadosService: ListarEmpleadosService) {
    config.backdrop = 'static';
    config.keyboard = false;
  }

  ngOnInit(): void {
    this.listarTurnos();
    this.formulario();
    this.listarEmpleados();
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
    this.turnosService.agregarTurno(this.form.value);
    this.formulario();

  }

  public listarTurnos(){
    console.log(this.turnosService.listarTurnos())
    this.turnosService.listarTurnos().
    subscribe((data) => {
      if (data) {
        this.turnos = data;
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

}
