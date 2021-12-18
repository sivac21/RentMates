import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { UserAuthenticationManagementService } from '../service/user-authentication-management.service';


@Component({
  selector: 'app-register-owner',
  templateUrl: './register-owner.component.html',
  styleUrls: ['./register-owner.component.css']
})
export class RegisterOwnerComponent implements OnInit {

  registerSection:FormGroup;
  userObject: User = new User();

  constructor(private userAuthenticationManagementService: UserAuthenticationManagementService,
    private router: Router, private formbuilder:FormBuilder) { }

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
    this.userObject.userRole = "OWNER";

    this.userAuthenticationManagementService.jwtRegister(this.userObject).subscribe(response =>{
      console.log('on creating response', response);
      this.router.navigate(['/login']);
    });
  }

  loginclick(){
    this.router.navigate(['/login']);
  }


}
