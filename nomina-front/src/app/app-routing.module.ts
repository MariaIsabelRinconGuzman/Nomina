import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  { path: 'nomina', loadChildren: () => import('././feature/turnos/turnos.module').then(mod => mod.TurnosModule) },
  { path: 'nomina', loadChildren: () => import('./feature/listar-empleados/listar-empleados.module').then(mod => mod.ListarEmpleadosModule) },

  { path: '**', redirectTo: 'nomina' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
