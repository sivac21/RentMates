import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TenantProfileService } from '../service/tenant-profile.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  profileDetails : any;
  retrivedImage: any;
  tenantEmailId: string;
  constructor(private tenantPofileService:TenantProfileService , private activatedRoute : ActivatedRoute) { }

  ngOnInit(): void {
    this.tenantEmailId = this.activatedRoute.snapshot.paramMap.get("email");
    
    if(this.tenantEmailId == null){
      this.getProfileDetails(localStorage.getItem("email"));
    }
    else{
      this.getProfileDetails(this.tenantEmailId);
    }

    // if(this.tenantEmailId == null){
    //   this.tenantPofileService.getTenantProfileDetails(this.tenantEmailId).subscribe(response => {
    //     console.log(response);
    //     this.profileDetails=response;
    //     this.retrivedImage='data:image/jpg;base64,'+this.profileDetails.image; 
    //   });

    
    // } 
    // } else{
    //   this.tenantPofileService.get(this.tenantEmailId).subscribe(response => {
    //     console.log(response);
    //     this.profileDetails=response[0];
    //     this.retrivedImage='data:image/jpg;base64,'+this.profileDetails.image; 
    //   });
    

    // this.tenantPofileService.getProfiles().subscribe(response => {
    //   console.log(response);
    //   this.profileDetails=response[0];
    //   this.retrivedImage='data:image/jpg;base64,'+this.profileDetails.image; 
    // });
   
  }

  getProfileDetails(email) {
    this.tenantPofileService.getTenantProfileDetails(email).subscribe(response => {
      console.log("This is logged in User Details", response);
      this.profileDetails = response;
      this.retrivedImage = 'data:image/jpg;base64,' + this.profileDetails.image;
    });
  }
}
