import { Component, OnInit } from '@angular/core';
import { NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';
import { Empleado } from '../../shared/model/empleado';

@Component({
  selector: 'app-listar-empleados',
  templateUrl: './listar-empleados.component.html',
  styleUrls: ['./listar-empleados.component.sass']
})
export class ListarEmpleadosComponent implements OnInit {
  empleados=[];
  empleadoPorId:Empleado;

  constructor(config: NgbModalConfig, private modalService: NgbModal) {
    config.backdrop = 'static';
    config.keyboard = false;
  }

  ngOnInit(): void {
    this.listaEmpleados();
  }
  public open(content): void {
    this.modalService.open(content);
  }
  public getEmpleadoPorId(id:number){
   this.empleadoPorId=this.empleados.find(empleado => empleado.id == id);
    console.log(this.empleados.find(empleado => empleado.id == id));
    
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
