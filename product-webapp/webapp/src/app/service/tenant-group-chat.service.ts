import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TenantGroupChatService {

  constructor(private http: HttpClient) { }

  // apiBaseUrl = 'http://localhost:8001';
  apiBaseUrl = environment.apiBaseUrl + '/tenant-profile-service';

  getTenantGroupChat() {
    return this.http.get("http://localhost:3000/groups");
  }

  getTenantGroups() {
    return this.http.get(this.apiBaseUrl + "/api/v1/groups");
  }

  createTenantGroups(tenantGroupObj) {
    return this.http.post(this.apiBaseUrl + "/api/v1/group", tenantGroupObj);
  }

  getTenantGroupDetails(groupName) {
    return this.http.get(this.apiBaseUrl + "/api/v1/groups/" + groupName);
  }

  getAllTenantGroupsOfLoggedInUser(email) {
    return this.http.get(this.apiBaseUrl + "/api/v1/tenantgroups/" + email);
  }

  updateGroupChat(groupChat, groupName) {
    return this.http.put(this.apiBaseUrl + "/api/v1/group/"+ groupName, groupChat);
  }
}
