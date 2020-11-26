import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo(): Promise<unknown> {
    return browser.get(browser.baseUrl) as Promise<unknown>;
  }
  
  seleccionarBoton(nombreBoton) {
	  console.log('ENTROOOOOOOOOOOOOOOOOOOOOOOO', nombreBoton);
    element(by.name(nombreBoton)).click();
  }

  validarTexto(nombreInput) {
    return expect(element(by.id('nombreInput')).isPresent()).toBe(true);
  }
  
  cambiarFecha(fecha) {
    element(by.id('fecha')).sendKeys(fecha);
  }
  
  seleccionarEmpleado(nombreSelector, empleado) {
    element(by.id(nombreSelector)).sendKeys(empleado);
  }
}
