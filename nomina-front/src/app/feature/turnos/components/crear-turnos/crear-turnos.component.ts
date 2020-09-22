import { Component, OnInit } from '@angular/core';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormGroup, FormControl } from '@angular/forms';
import { TurnosService } from '../../shared/service/turnos.service';

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

  constructor(config: NgbModalConfig, private modalService: NgbModal, private turnosService:TurnosService) {
    config.backdrop = 'static';
    config.keyboard = false;
  }

  ngOnInit(): void {
    this.listaEmpleados();
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
    this.turnosService.agregarTurno(this.form.value);
    this.formulario();

  }

  public listarTurnos(){
    console.log(this.turnosService.listarTurnos())
    this.turnos=this.turnosService.listarTurnos();
            
        
  }

  public listaEmpleados(){
    const empleado1 = {
      id: 1,
      nombre: "juan",
      cargo:1
    }
    const empleado2 = {
      id: 2,
      nombre: "pedro",
      cargo:1
    }
    const empleado3 = {
      id: 3,
      nombre: "andrea",
      cargo:1
    }
    this.empleados.push(empleado1,empleado2,empleado3);
    console.log(this.empleados);
    

  }
}
