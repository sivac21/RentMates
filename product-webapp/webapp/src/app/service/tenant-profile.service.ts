import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TenantProfile } from '../model/tenant-profile';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TenantProfileService {

  constructor(private httpClient:HttpClient) { }

  // apiBaseUrl = 'http://localhost:8001';
  apiBaseUrl = environment.apiBaseUrl + '/tenant-profile-service';

  createTenantProfile(tenantProfile: TenantProfile)
  {
    return this.httpClient.post(this.apiBaseUrl+"/api/v1/profile", tenantProfile); 
  }

  updateTenantProfile(tenantProfile: TenantProfile, profileImage: File, email: String)
  {
    const data: FormData = new FormData();
    data.append('file', profileImage);
    data.append('tenantprofile', JSON.stringify(tenantProfile));
    return this.httpClient.put(this.apiBaseUrl+"/api/v1/profile/" + email, data); 
  }

  getProfiles()
  {
    return this.httpClient.get("http://localhost:3000/profiles"); 
  }

  getTenantProfileDetails(email : string){
    return this.httpClient.get<any>(this.apiBaseUrl+"/api/v1/profiles/"+ email);
  }
}
