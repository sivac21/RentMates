import { Component, OnInit } from '@angular/core';
import { PropertyProfileService } from '../service/property-profile.service';
import * as moment from 'moment';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-property-details',
  templateUrl: './property-details.component.html',
  styleUrls: ['./property-details.component.css']
})
export class PropertyDetailsComponent implements OnInit {

  today = new Date().toLocaleDateString();

  propertyDetails: any;
  time: any;
  propertyName :any;
  retrivedImage : any;

  constructor(private propertyOwnerService: PropertyProfileService , private activatedRoute : ActivatedRoute) { }

  ngOnInit(): void {

    this.propertyName = this.activatedRoute.snapshot.paramMap.get("propertyname");
    if(this.propertyName!=null){
 this.getPropertyDetails();
    }
    // this.propertyOwnerService.getPropertyDetails().subscribe(response=>{
    //   console.log(response);
    //   this.propertyDetails = response[0];
    // }) 
  }
  getPropertyDetails(){
    this.propertyOwnerService.getParticularPropertyDetails(this.propertyName).subscribe(response=>{
      console.log(response);
      this.propertyDetails = response;
      this.retrivedImage='data:image/jpg;base64,'+this.propertyDetails.image;
    }) 
  }

  formatDate(momentDate) {
    // this.time = moment(momentDate);
    // return this.time.fromNow();
    return moment(momentDate).format('DD MMM YYYY');
    // hh:mm:ss a 
  }

}
