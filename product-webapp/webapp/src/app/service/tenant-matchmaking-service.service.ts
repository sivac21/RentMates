import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TenantProfile } from '../model/tenant-profile';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class TenantMatchmakingServiceService {

  // apiBaseUrl = 'http://localhost:8002';
  apiBaseUrl = environment.apiBaseUrl + '/tenant-matchmaking-service';

  constructor(private http: HttpClient) { }

  getRecommendedTenantList(emailid,tenantGender,tenantState,tenantageGroup) {
    return this.http.get(this.apiBaseUrl+"/api/v1/matchedTenant",{
      params:{
        email : emailid, gender : tenantGender , state : tenantState , ageGroup : tenantageGroup
      }
    });
  }

  createTenantMatchmakingNode(tenantProfile: TenantProfile) {
    return this.http.post(this.apiBaseUrl+"/api/v1/tenant", tenantProfile);
  }


  createIntrestedTenantRelation(senderEmail,receiverEmail) {
    return this.http.get(this.apiBaseUrl+"/api/v1/interestedTenant",{
      params:{
        sender : senderEmail, receiver : receiverEmail
      }
    });
  }

  createAcceptedTenantRelation(senderEmail,receiverEmail) {
    return this.http.get(this.apiBaseUrl+"/api/v1/acceptedTenant",{
      params:{
        sender : senderEmail, receiver : receiverEmail
      }
    });
  }


  getIntrestedTenantList(email) {
    return this.http.get(this.apiBaseUrl+"/api/v1/showedInterest",{
      params:{
        emailId : email
      }
    });
  }



}
