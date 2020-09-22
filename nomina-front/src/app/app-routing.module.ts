import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  { path: 'turnos', loadChildren: () => import('././feature/turnos/turnos.module').then(mod => mod.TurnosModule) },
  { path: 'empleados', loadChildren: () => import('./feature/listar-empleados/listar-empleados.module').then(mod => mod.ListarEmpleadosModule) },

  { path: '**', redirectTo: 'turnos' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
