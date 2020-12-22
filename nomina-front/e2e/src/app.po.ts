import { browser, by, element, Key } from 'protractor';
import { protractor } from 'protractor/built/ptor';

export class AppPage {
  navigateTo(): Promise<unknown> {
    return browser.get(browser.baseUrl) as Promise<unknown>;
  }

  async seleccionarBoton(nombreBoton) {
    await element(by.id(nombreBoton)).click();
  }

  async seleccionarBotonTexto(nombreBoton) {
    await element(by.buttonText(nombreBoton)).click();
  }

  validarTexto(nombreInput) {
    return expect(element(by.id(nombreInput)).isPresent()).toBe(true);
  }

  cambiarFecha(fecha, hora) {
    element(by.id('fecha')).sendKeys(fecha);
    element(by.id('fecha')).sendKeys(protractor.Key.TAB);
    element(by.id('fecha')).sendKeys(hora);
  }

  seleccionarEmpleado(nombreSelector, empleado) {
    element(by.id(nombreSelector)).sendKeys(empleado);
  }
}