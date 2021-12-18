import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  userName: String;
  opened = false;
  link = "/home/createproperty";
  role: string;
  // recommendation = "/home/tenantrecommendation";
  profile = "/home/tenantprofile"

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.userName = localStorage.getItem("email").split("@")[0];
    this.role = localStorage.getItem("userRole");
    console.log("role", this.role);


  }


  goToHome() {
    this.router.navigate(['/home'])
  }

  logout() {
    // localStorage.removeItem("email");
    localStorage.clear();
    this.router.navigate(['/']);
  }
}
