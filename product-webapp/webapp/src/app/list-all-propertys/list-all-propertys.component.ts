import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { PropertyProfileService } from '../service/property-profile.service';

@Component({
  selector: 'app-list-all-propertys',
  templateUrl: './list-all-propertys.component.html',
  styleUrls: ['./list-all-propertys.component.css']
})
export class ListAllPropertysComponent implements OnInit {

  propertyArray: any;
  page = 1;
  totalLength = 0;
  searchForm: FormGroup;

  constructor(private propertyOwnerService: PropertyProfileService , private router : Router) { }

  ngOnInit(): void {
    this.searchForm = new FormGroup({
      searchWord: new FormControl("")
    });
    // this.propertyOwnerService.getAllPropertys().subscribe(response=>{
    //   console.log(response);
    //   this.propertyArray = response;
    //   this.totalLength = this.propertyArray.length;
    // }); 
     this.getProperties();
  }

  getProperties(){
    this.propertyOwnerService.getAllProperties().subscribe(response=>{
      console.log(response);
      this.propertyArray = response.content;
      this.propertyArray.reverse();
      this.totalLength = this.propertyArray.length;
    }) ;
  }

  getProperty(property){
this.router.navigate(['/home/propertydetails',property.propertyName]);
  }

  searchProperties(){
    this.propertyOwnerService.getSearchedProperties(this.searchForm.value.searchWord).subscribe(response=>{
      this.propertyArray = response;
      this.propertyArray.reverse();
      this.totalLength = this.propertyArray.length;
    })
  }

  resetSearch(){
    this.getProperties();
    this.searchForm.reset();
  }
}
