import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TenantGroupChatComponent } from './tenant-group-chat.component';

describe('TenantGroupChatComponent', () => {
  let component: TenantGroupChatComponent;
  let fixture: ComponentFixture<TenantGroupChatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TenantGroupChatComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TenantGroupChatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
