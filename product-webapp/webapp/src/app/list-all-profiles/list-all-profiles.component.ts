import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TenantMatchmakingServiceService } from '../service/tenant-matchmaking-service.service';
import { TenantProfileService } from '../service/tenant-profile.service';

@Component({
  selector: 'app-list-all-profiles',
  templateUrl: './list-all-profiles.component.html',
  styleUrls: ['./list-all-profiles.component.css']
})
export class ListAllProfilesComponent implements OnInit {

  profileArray: any;
  page = 1;
  totalLength = 0;
  email = "siva@gmail.com";

  constructor(private tenantProfileService: TenantProfileService, private router : Router , private tenantMatchMakingService : TenantMatchmakingServiceService) { }

  ngOnInit(): void {
    // this.getProfiles(this.email);
    // this.profileArray = ["suriya@abc.com", "kishore@abc.com", "kishore@gmail.com", "dolly@gmail.com", "abishek@gmail.com", "Vishnu@gmail.com", "priya@gmail.com"];
    this.tenantMatchMakingService.getIntrestedTenantList(localStorage.getItem("email")).subscribe(response => {
      console.log(response);
      this.profileArray = response;
      this.profileArray.reverse();
      this.totalLength = this.profileArray.length;
    });
   
  }

  getProfiles(email: any){
    this.tenantProfileService.getTenantProfileDetails(email).subscribe(response => {
      console.log(response);
      this.profileArray = response.content;
    });
  }

  getProfile(profile){
    this.router.navigate(['/home/userprofile',profile.email])
  }

}

