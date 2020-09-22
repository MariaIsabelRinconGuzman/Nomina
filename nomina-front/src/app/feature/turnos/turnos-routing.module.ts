import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CrearTurnosComponent } from './components/crear-turnos/crear-turnos.component';


const routes: Routes = [
      {
        path: 'turno',
        component: CrearTurnosComponent
      }
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TurnosRoutingModule { }
