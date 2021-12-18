import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAllProfilesComponent } from './list-all-profiles.component';

describe('ListAllProfilesComponent', () => {
  let component: ListAllProfilesComponent;
  let fixture: ComponentFixture<ListAllProfilesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListAllProfilesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListAllProfilesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
