import { Salario } from '../../listar-empleados/shared/model/salario';

export interface Empleado{
    idEmpleado:number,
    nombre:string,
    salario:Salario
}