import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TurnosService {
  turnos=[];


  constructor() { }

  public agregarTurno(turno:any){
    this.turnos.push(turno);
  }
  public listarTurnos():any{
    return this.turnos
  }
}
