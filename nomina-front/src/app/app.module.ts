import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { TurnosModule } from './feature/turnos/turnos.module';
import { NgbCarouselModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ListarEmpleadosModule } from './feature/listar-empleados/listar-empleados.module';
import { UrlRuta } from './feature/shared/urlRuta';
import { HttpClientModule } from '@angular/common/http';
import { ListarEmpleadosService } from './feature/shared/service/listar-empleados.service';
import { FullCalendarModule } from '@fullcalendar/angular';
import dayGridPlugin from '@fullcalendar/daygrid'; // a plugin
//import interactionPlugin from '@fullcalendar/interaction';
import { AppComponent } from './app.component';

FullCalendarModule.registerPlugins([ // register FullCalendar plugins
  dayGridPlugin
  //interactionPlugin
]);

@NgModule({
  declarations: [
    AppComponent    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    TurnosModule,
    NgbCarouselModule,
    NgbModule,
    BrowserAnimationsModule,
    ListarEmpleadosModule,
    FullCalendarModule
  ],
  providers: [UrlRuta, ListarEmpleadosService],
  bootstrap: [AppComponent]
})
export class AppModule { }
