import { TestBed } from '@angular/core/testing';

import { PropertyProfileService } from './property-profile.service';

describe('PropertyProfileService', () => {
  let service: PropertyProfileService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PropertyProfileService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
