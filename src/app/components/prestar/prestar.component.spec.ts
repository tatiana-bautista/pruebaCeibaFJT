import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrestarComponent } from './prestar.component';

describe('PrestarComponent', () => {
  let component: PrestarComponent;
  let fixture: ComponentFixture<PrestarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrestarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrestarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
