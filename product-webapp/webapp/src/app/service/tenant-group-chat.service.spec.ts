import { TestBed } from '@angular/core/testing';

import { TenantGroupChatService } from './tenant-group-chat.service';

describe('TenantGroupChatService', () => {
  let service: TenantGroupChatService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TenantGroupChatService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
