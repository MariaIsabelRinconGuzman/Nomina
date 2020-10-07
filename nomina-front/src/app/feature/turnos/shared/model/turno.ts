import { Empleado } from 'src/app/feature/shared/model/empleado';

export interface Turno{
   id?:number,
   idEmpleado?:number,
   empleado?:Empleado,
   fecha:Date
}