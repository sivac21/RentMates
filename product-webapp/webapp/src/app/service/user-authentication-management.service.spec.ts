import { TestBed } from '@angular/core/testing';

import { UserAuthenticationManagementService } from './user-authentication-management.service';

describe('UserAuthenticationManagementService', () => {
  let service: UserAuthenticationManagementService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserAuthenticationManagementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
