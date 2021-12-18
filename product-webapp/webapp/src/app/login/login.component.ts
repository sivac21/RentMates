import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuthenticationManagementService } from '../service/user-authentication-management.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from '../model/user';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  loginSection: FormGroup;
  userObject: User = new User();

  constructor(private userAuthenticationManagementService: UserAuthenticationManagementService,
    private router: Router, private formbuilder: FormBuilder) {


  }



  ngOnInit(): void {
    this.loginSection = new FormGroup({
      email: new FormControl("", [Validators.required]),
      password: new FormControl("", [Validators.required])
    });
  }



  onLogIn() {

    this.userObject.email = this.loginSection.value.email;
    this.userObject.password = this.loginSection.value.password;
    this.userObject.userRole = "TENANT";

    this.userAuthenticationManagementService.jwtLogin(this.userObject).subscribe(response => {
      console.log('on creating response', response);
      localStorage.setItem("email", this.loginSection.value.email);
      localStorage.setItem("userRole", response.userRole);
      this.loginSection.reset();
      if (response.userRole == 'TENANT') {
        this.router.navigate(['/home']);
      }
      else {
        this.router.navigate(['/home/createproperty']);
      }


    },
      error => {
        console.log("error while login", error);
      });
  }

  login() {
    this.userAuthenticationManagementService.login();
  }

  registerclick() {
    this.router.navigate(['/register']);
  }

  registerownerclick() {
    this.router.navigate(['/register-owner']);
  }

  // getErrorMessage() {
  //   if (this.loginSection.email.hasError('required')) {
  //     return 'You must enter a value';
  //   }

  //   return this.email.hasError('email') ? 'Not a valid email' : '';
  // }


}
