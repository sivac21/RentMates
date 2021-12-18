import { ComponentFixture, TestBed } from '@angular/core/testing';
import { TenantRecommendationComponent } from './tenant-recommendation.component';

describe('TenantRecommendationComponent', () => {
  let component: TenantRecommendationComponent;
  let fixture: ComponentFixture<TenantRecommendationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TenantRecommendationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TenantRecommendationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
