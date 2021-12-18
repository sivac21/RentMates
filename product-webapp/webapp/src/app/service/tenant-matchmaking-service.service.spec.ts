import { TestBed } from '@angular/core/testing';

import { TenantMatchmakingServiceService } from './tenant-matchmaking-service.service';

describe('TenantMatchmakingServiceService', () => {
  let service: TenantMatchmakingServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TenantMatchmakingServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
