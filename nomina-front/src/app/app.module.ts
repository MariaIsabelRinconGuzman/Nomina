import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TurnosModule } from './feature/turnos/turnos.module';
import { NgbCarouselModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ListarEmpleadosModule } from './feature/listar-empleados/listar-empleados.module';
import { UrlRuta } from './feature/shared/urlRuta';
import { HttpClientModule } from '@angular/common/http';
import { ListarEmpleadosService } from './feature/shared/service/listar-empleados.service';

@NgModule({
  declarations: [
    AppComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    TurnosModule,
    NgbCarouselModule,
    NgbModule,
    BrowserAnimationsModule,
    ListarEmpleadosModule
  ],
  providers: [UrlRuta, ListarEmpleadosService],
  bootstrap: [AppComponent]
})
export class AppModule { }
