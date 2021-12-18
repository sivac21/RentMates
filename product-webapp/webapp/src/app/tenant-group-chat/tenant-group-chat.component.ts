import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { GroupChat } from "../model/group-chat";
import { TenantGroupChatService } from "../service/tenant-group-chat.service";
import { TenantProfileService } from "../service/tenant-profile.service";

@Component({
  selector: "app-tenant-group-chat",
  templateUrl: "./tenant-group-chat.component.html",
  styleUrls: ["./tenant-group-chat.component.css"],
})
export class TenantGroupChatComponent implements OnInit {
  loggedInUser = "";

  groupchat: any;
  groupName: any;
  // loggedInUser: any;
  profileDetails: any;
  retrivedImage: any;
  tenantGroupList: any;
  groupDetails: any;
  groupChatObj: GroupChat = new GroupChat();

  replyForm: FormGroup;

  constructor(
    private tenantGroupChatService: TenantGroupChatService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private tenantProfileService: TenantProfileService
  ) {}

  ngOnInit(): void {

    this.loggedInUser=localStorage.getItem("email");
    this.replyForm = new FormGroup({
      reply: new FormControl("", [Validators.required])
    });
    this.getGroups(localStorage.getItem("email"));
  }

  getGroups(email) {
    this.tenantGroupChatService
      .getAllTenantGroupsOfLoggedInUser(email)
      .subscribe((response) => {
        console.log(response);
        this.tenantGroupList = response;
        this.tenantGroupList.reverse();
        this.groupDetails = this.tenantGroupList[0];
        if (this.groupDetails.tenantMember1 == this.loggedInUser) {
          this.getTenantDetails(this.groupDetails.tenantMember2);
        } else {
          this.getTenantDetails(this.groupDetails.tenantMember1);
        }
      });
  }

  getTenantDetails(email) {
    this.tenantProfileService
      .getTenantProfileDetails(email)
      .subscribe((response) => {
        console.log("profileDetails",response);
        this.profileDetails = response;
        this.retrivedImage =
          "data:image/jpg;base64," + this.profileDetails.image;
      });
  }

  addChat(groupName){
    this.groupChatObj.message = this.replyForm.value.reply;
    this.groupChatObj.messageSendBy = this.loggedInUser;
    this.tenantGroupChatService.updateGroupChat(this.groupChatObj, groupName).subscribe(response => {
      this.replyForm.reset();
      this.getGroupDetails(groupName);
    });
  }

  getGroupDetails(groupName) {
    this.tenantGroupChatService.getTenantGroupDetails(groupName).subscribe(response => {
      this.groupDetails = response;
      if (this.groupDetails.tenantMember1 == this.loggedInUser) {
        this.getTenantDetails(this.groupDetails.tenantMember2);
      } else {
        this.getTenantDetails(this.groupDetails.tenantMember1);
      }
    });
  }

  profile(email){
    this.router.navigate(['/home/userprofile', email]);
  }

}
