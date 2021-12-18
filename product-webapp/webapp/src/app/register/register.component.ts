import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TenantProfile } from '../model/tenant-profile';
import { User } from '../model/user';
import { TenantProfileService } from '../service/tenant-profile.service';
import { UserAuthenticationManagementService } from '../service/user-authentication-management.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerSection:FormGroup;
  userObject: User = new User();
  tenantProfile : TenantProfile = new TenantProfile();

  constructor(private userAuthenticationManagementService: UserAuthenticationManagementService,
    private router: Router, private tenantProfileService : TenantProfileService ) { }

  ngOnInit(): void {
    this.registerSection = new FormGroup({
      email: new FormControl("",[Validators.required]),
      password: new FormControl("",[Validators.required])
    });
  }


  // getErrorMessage() {
  //   if (this.email.hasError('required')) {
  //     return 'You must enter a value';
  //   }

  //   return this.email.hasError('email') ? 'Not a valid email' : '';
  // }

  onRegister(){

    this.userObject.email = this.registerSection.value.email;
    this.userObject.password = this.registerSection.value.password;
    this.userObject.userRole = "TENANT";

    this.userAuthenticationManagementService.jwtRegister(this.userObject).subscribe(response =>{
      console.log('on creating response', response);
      this.router.navigate(['/login']);

      //setting email to tenant profile service
      this.tenantProfile.email=this.registerSection.value.email;
      this.tenantProfileService.createTenantProfile(this.tenantProfile).subscribe(response=>{
        console.log("email sent to Tenant profile service",response);
      });

    });
  }

  loginclick(){
    this.router.navigate(['/login']);
  }

}
