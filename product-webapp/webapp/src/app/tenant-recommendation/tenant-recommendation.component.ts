import { Component, OnInit } from '@angular/core';
import { TenantProfileService } from '../service/tenant-profile.service';
import { TooltipPosition } from '@angular/material/tooltip';
import { ActivatedRoute } from '@angular/router';
import { TenantMatchmakingServiceService } from '../service/tenant-matchmaking-service.service';
import { TenantProfile } from '../model/tenant-profile';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-tenant-recommendation',
  templateUrl: './tenant-recommendation.component.html',
  styleUrls: ['./tenant-recommendation.component.css']
})
export class TenantRecommendationComponent implements OnInit {

  profileDetails: any;
  retrivedImage: any;
  tenantEmailId: string;
  ageGroup: string;
  recommendationArray: any;
  profileObj: TenantProfile = new TenantProfile();

  constructor(private tenantPofileService: TenantProfileService, private activatedRoute: ActivatedRoute, private matchMakingService: TenantMatchmakingServiceService , private snackbar : MatSnackBar) { }

  collection = {};
  ngOnInit(): void {
    this.tenantEmailId = this.activatedRoute.snapshot.paramMap.get("email");
    this.getRecommendation();
    // this.tenantPofileService.getProfiles().subscribe(response => {
    //   console.log(response);
    //   this.profileDetails = response[0];
    //   this.retrivedImage = 'data:image/jpg;base64,' + this.profileDetails.image;
    // });
  }
  getRecommendation() {
    this.tenantPofileService.getTenantProfileDetails(localStorage.getItem("email")).subscribe(response => {
      console.log("This is logged in User Details", response);
      this.profileObj = response;
      // this.profileDetails = response;
      // this.retrivedImage = 'data:image/jpg;base64,' + this.profileDetails.image;

      if (this.profileObj.age > 20 && this.profileObj.age < 31) {
        this.ageGroup = "21to30";
      }
      if (this.profileObj.age > 30 && this.profileObj.age < 41) {
        this.ageGroup = "31to40";
      }
      if (this.profileObj.age > 40) {
        this.ageGroup = ">40";
      }
      if (this.profileObj.age < 20) {
        this.ageGroup = "<20";
      }


      this.matchMakingService.getRecommendedTenantList(localStorage.getItem("email"), this.profileObj.gender, this.profileObj.state, this.ageGroup).subscribe((result) => {
        console.log("Tenant Recommendation", result);
        this.recommendationArray = result;
        this.getRecommendationTenantDetails(this.recommendationArray[0]);
        this.collection = result;
      });


    });
  }

  // drop(event: CdkDragDrop<profileDetails?.language>) {
  //   moveItemInArray(this.vegetables, event.previousIndex, event.currentIndex);
  // }


  interested(profileDetails) {
this.snackbar.open('Successfully added as intrested !','',{
  duration: 2000,
  horizontalPosition:'center',
  verticalPosition:'bottom'
});

    this.matchMakingService.createIntrestedTenantRelation(localStorage.getItem("email"), profileDetails.email).subscribe((result) => {
      console.log("intrested Tenant", Response)
    });

  }

  notInterested(profileDetails) {
    //pop that selected user from recommendation array
    this.recommendationArray.splice(0, 1);

    this.getRecommendationTenantDetails(this.recommendationArray[0]);
    // this.matchMakingService.createIntrestedTenantRelation(localStorage.getItem("email"),profileDetails.email).subscribe((result) => {
    // console.log("intrested Tenant",Response)
    // });

  }

  getRecommendationTenantDetails(email) {
    this.tenantPofileService.getTenantProfileDetails(email).subscribe(response => {
      this.profileDetails = response;
      this.retrivedImage = 'data:image/jpg;base64,' + this.profileDetails.image;
    });
  }


}
