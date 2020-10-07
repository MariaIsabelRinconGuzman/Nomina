import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TurnosRoutingModule } from './turnos-routing.module';
import { CrearTurnosComponent } from './components/crear-turnos/crear-turnos.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FullCalendarModule } from '@fullcalendar/angular';



@NgModule({
  declarations: [CrearTurnosComponent],
  imports: [
    CommonModule,
    TurnosRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    FullCalendarModule   
  ]
})
export class TurnosModule { }
