import { Component, OnInit } from '@angular/core';
import { NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';
import { Empleado } from 'src/app/feature/shared/model/empleado';
import { ListarEmpleadosService } from 'src/app/feature/shared/service/listar-empleados.service';

@Component({
  selector: 'app-listar-empleados',
  templateUrl: './listar-empleados.component.html',
  styleUrls: ['./listar-empleados.component.sass']
})
export class ListarEmpleadosComponent implements OnInit {
  empleados=[];
  empleadoPorId:Empleado;

  constructor(private listarEmpleadosService: ListarEmpleadosService, config: NgbModalConfig, private modalService: NgbModal) {
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
    this.listarEmpleadosService.listarEmpleados().
      subscribe((data) => {
        if (data) {
          this.empleados = data;
        }
      });
    console.log(this.empleados);
  }
}
