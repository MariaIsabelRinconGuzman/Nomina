import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BaseService } from 'src/app/core/services/base.service';
import { environment } from 'src/environments/environment';
import { UrlRuta } from '../urlRuta';
import { Empleado } from '../model/empleado';

@Injectable()
export class ListarEmpleadosService extends BaseService {

  constructor(protected http: HttpClient, private urlRuta : UrlRuta) {
    super(http);
  }

  readonly route = this.urlRuta.getRuta();
  
  public listarEmpleados() {
    return this.doGet<Empleado[]>(`${environment.endpoint}empleado`);
  }
}