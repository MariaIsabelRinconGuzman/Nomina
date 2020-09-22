import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarEmpleadosComponent } from './components/listar-empleados/listar-empleados.component';


const routes: Routes = [
  {
    path: 'empleado',
    component: ListarEmpleadosComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ListarEmpleadosRoutingModule { }
