import { AppPage } from './app.po';
import { browser, logging } from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
	browser.get('http://localhost:4200/nomina/turno');
  });

  it('Crear turno', () => {
    page.navigateTo();
	page.seleccionarBoton('botonCrearTurno');
	page.cambiarFecha('01112020');
	page.seleccionarEmpleado('listaEmpleados', 'g');
	page.seleccionarBoton('botonAceptar');
  });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
