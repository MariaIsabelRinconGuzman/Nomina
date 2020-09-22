import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ListarEmpleadosRoutingModule } from './listar-empleados-routing.module';
import { ListarEmpleadosComponent } from './components/listar-empleados/listar-empleados.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [ListarEmpleadosComponent],
  imports: [
    CommonModule,
    ListarEmpleadosRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class ListarEmpleadosModule { }
