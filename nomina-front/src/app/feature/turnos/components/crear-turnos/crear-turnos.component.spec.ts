import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearTurnosComponent } from './crear-turnos.component';

describe('CrearTurnosComponent', () => {
  let component: CrearTurnosComponent;
  let fixture: ComponentFixture<CrearTurnosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CrearTurnosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearTurnosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
