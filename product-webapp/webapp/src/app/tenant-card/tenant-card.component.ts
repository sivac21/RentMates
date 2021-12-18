import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TenantGroup } from '../model/tenant-group';
import { TenantGroupChatService } from '../service/tenant-group-chat.service';
import { TenantMatchmakingServiceService } from '../service/tenant-matchmaking-service.service';
import { TenantProfileService } from '../service/tenant-profile.service';
import { TenantGroupChatComponent } from '../tenant-group-chat/tenant-group-chat.component';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-tenant-card',
  templateUrl: './tenant-card.component.html',
  styleUrls: ['./tenant-card.component.css']
})
export class TenantCardComponent implements OnInit {
  profileDetails:any;
  retrivedImage:any;
  tenantGroupObj : TenantGroup = new TenantGroup(); 

  @Input() public profile: any;
  constructor(private tenantProfileService: TenantProfileService, private tenantMatchMaking : TenantMatchmakingServiceService , private tenantGroupService : TenantGroupChatService, private router : Router, private snackbar : MatSnackBar) { }

  ngOnInit(): void {
    this.getProfileDetails(this.profile);
  }

  getProfileDetails(email: any){
    this.tenantProfileService.getTenantProfileDetails(email).subscribe(response => {
      console.log(response);
      this.profileDetails = response;
      this.retrivedImage='data:image/jpg;base64,'+this.profileDetails.image;
    });
  }

  acceptTenant(){
    this.snackbar.open('Successfully accepted the request !','',{
      duration: 2000,
      horizontalPosition:'center',
      verticalPosition:'bottom'
    });
    // this.tenantMatchMaking.createAcceptedTenantRelation(localStorage.getItem("email"),this.profileDetails.email).subscribe(response => {
    //   console.log(response);     
    // });
    this.tenantGroupObj.tenantMember1=localStorage.getItem("email");
    this.tenantGroupObj.tenantMember2=this.profileDetails.email;
    this.tenantGroupObj.groupCreatedBy=localStorage.getItem("email");


    this.tenantGroupService.createTenantGroups(this.tenantGroupObj).subscribe(response => {
      console.log(response);
      this.router.navigate(['/home/tenantgroupchat']);
    });

  }
}
