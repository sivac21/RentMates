import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAllPropertysComponent } from './list-all-propertys.component';

describe('ListAllPropertysComponent', () => {
  let component: ListAllPropertysComponent;
  let fixture: ComponentFixture<ListAllPropertysComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListAllPropertysComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListAllPropertysComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
