import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BaseService } from 'src/app/core/services/base.service';
import { UrlRuta } from 'src/app/feature/shared/urlRuta';
import { environment } from 'src/environments/environment';
import { Turno } from '../model/turno';

@Injectable({
  providedIn: 'root'
})
export class TurnosService extends BaseService{
  turnos=[];

  constructor(protected http: HttpClient, private urlRuta : UrlRuta) {
    super(http);
  }

  public agregarTurno(body){
    return this.doPost(`${environment.endpoint}turno`, body);
  }
  public listarTurnos(){
    return this.doGet<Turno[]>(`${environment.endpoint}horario`);
  }

/*  public agregarTurno(turno:any){
    this.turnos.push(turno);
  }
  public listarTurnos():any{
    return this.turnos
  }*/
}
