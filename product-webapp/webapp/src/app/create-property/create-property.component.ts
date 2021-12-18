import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl, NgForm } from '@angular/forms';
import { MatChipInputEvent } from '@angular/material/chips';
import { Property } from '../model/property';
import { COMMA, ENTER } from '@angular/cdk/keycodes';
import { MatAutocompleteSelectedEvent } from '@angular/material/autocomplete';
import { PropertyProfileService } from '../service/property-profile.service';
import * as moment from 'moment';
import { RoomAmenities } from '../model/room-amenities';
import { Rules } from '../model/rules';
import { AvailableAmenities } from '../model/available-amenities';
import { Router } from '@angular/router';



interface Food {
  value: string;
  viewValue: string;
}

interface Gender {
  value: string;
  viewValue: string;
}

interface Work {
  value: string;
  viewValue: string;
}

interface Fod {
  value: string;
  viewValue: string;
}

interface Laundary {
  value: string;
  viewValue: string;
}

interface Room {
  value: string;
  viewValue: string;
}

interface Parking {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-create-property',
  templateUrl: './create-property.component.html',
  styleUrls: ['./create-property.component.css']
})
export class CreatePropertyComponent implements OnInit {


  //image Upload
  // urls=[]

  // selectFiles(event){
  //   if(event.target.files){
  //     for(var i=0;i<File.length;i++){
  //       var reader =new FileReader()
  //       reader.readAsDataURL(event.target.files[i])
  //       reader.onload=(event.target.result)
  //     }
  //   }
  // }


  //Chip setup
  visible: boolean = true;
  selectable: boolean = true;
  removable: boolean = true;
  addOnBlur: boolean = false;

  separatorKeysCodes = [ENTER, COMMA];

  nearByPlaceCtrl = new FormControl();

  nearByPlaces = [
  ];


  @ViewChild('nearByPlaceInput') nearByPlaceInput: ElementRef;
  //Till here

  



  foods: Food[] = [
    { value: '1 RK', viewValue: '1 RK' },
    { value: '1 BHK', viewValue: '1 BHK' },
    { value: '2 BHK', viewValue: '2 BHK' },
    { value: '3+ BHK', viewValue: '3+ BHK' },
  ];

  genders: Gender[] = [
    { value: 'MALE', viewValue: 'MALE' },
    { value: 'FEMALE', viewValue: 'FEMALE' },
    { value: 'OTHERS', viewValue: 'OTHERS' },
  ];

  works: Work[] = [
    { value: 'STUDENT', viewValue: 'STUDENT' },
    { value: 'WORKING PROFESSIONAL', viewValue: 'WORKING PROFESSIONAL' },
    { value: 'OTHER', viewValue: 'OTHER' }
  ];

  fods: Fod[] = [
    { value: 'true', viewValue: 'Yes' },
    { value: 'false', viewValue: 'No' }
  ];

  laundarys: Laundary[] = [
    { value: 'true', viewValue: 'Yes' },
    { value: 'false', viewValue: 'No' }

  ];
  rooms: Room[] = [
    { value: 'true', viewValue: 'Yes' },
    { value: 'false', viewValue: 'No' }
  ];

  parkings: Parking[] = [
    { value: 'BIKE', viewValue: 'BIKE' },
    { value: 'CAR', viewValue: 'CAR' },
    { value: 'BOTH', viewValue: 'BOTH' },
    { value: 'NONE', viewValue: 'NONE' }
  ]


  propertyFormGroup: FormGroup;
  propertyObject: Property = new Property();
  roomAmenitiesObject: RoomAmenities = new RoomAmenities();
  rulesObject: Rules = new Rules();
  availableAmenitiesObject : AvailableAmenities = new AvailableAmenities();
  files: any[] = [];


  constructor(private prop: FormBuilder, private proper: PropertyProfileService, private router: Router) { }



  ngOnInit(): void {

    this.propertyFormGroup = new FormGroup({

      propertyName: new FormControl("", [Validators.required]),
      roomType: new FormControl("", [Validators.required]),
      expectedRent: new FormControl("", [Validators.required]),
      advancedDeposit: new FormControl("", [Validators.required]),
      city: new FormControl("", [Validators.required]),
      state: new FormControl("", [Validators.required]),
      locality: new FormControl("", [Validators.required]),
      nearByPlaces: new FormControl("", [Validators.required]),
      ownerContactNumber: new FormControl("",[Validators.required]),
      placeAvailableFor: new FormControl("", [Validators.required]),
      preferredTenant: new FormControl("", [Validators.required]),
      foodAvailability: new FormControl("", [Validators.required]),
      availableFrom: new FormControl("", [Validators.required]),
      laundary: new FormControl("", [Validators.required]),
      roomCleaningService: new FormControl("", [Validators.required]),
      parking: new FormControl("", [Validators.required]),
      image : new FormControl(""),
      cupboard: new FormControl(""),
      ac: new FormControl(""),
      tv: new FormControl(""),
      geyser: new FormControl(""),
      bedding: new FormControl(""),

      smoking: new FormControl(""),
      girlsEntry: new FormControl(""),
      nonVeg: new FormControl(""),
      drinking: new FormControl(""),
      guardianStay: new FormControl(""),

      commonTv: new FormControl(""),
      powerBackup: new FormControl(""),
      wifi: new FormControl(""),
      gym: new FormControl(""),
      refrigerator: new FormControl(""),
      lift: new FormControl(""),

    })
  }


  


  postNewProperty() {
    console.log('formValue', this.propertyFormGroup.value);
    this.propertyObject.propertyName = this.propertyFormGroup.value.propertyName;
    this.propertyObject.roomType = this.propertyFormGroup.value.roomType;
    this.propertyObject.expectedRent = this.propertyFormGroup.value.expectedRent;
    this.propertyObject.advancedDeposit = this.propertyFormGroup.value.advancedDeposit;
    this.propertyObject.city = this.propertyFormGroup.value.city;
    this.propertyObject.state = this.propertyFormGroup.value.state;
    this.propertyObject.locality = this.propertyFormGroup.value.locality;
    this.propertyObject.nearByPlace = this.nearByPlaces;
    this.propertyObject.ownerContactNumber=this.propertyFormGroup.value.ownerContactNumber;
    this.propertyObject.placeAvailableFor = this.propertyFormGroup.value.placeAvailableFor;
    this.propertyObject.preferredTenant = this.propertyFormGroup.value.preferredTenant;
    this.propertyObject.foodAvailability = this.propertyFormGroup.value.foodAvailability;
    this.propertyObject.availableFrom = moment(this.propertyFormGroup.value.availableFrom).valueOf();
    this.propertyObject.laundary = this.propertyFormGroup.value.laundary;
    this.propertyObject.roomCleaningService = this.propertyFormGroup.value.roomCleaningService;
    this.propertyObject.parking = this.propertyFormGroup.value.parking;
    this.propertyObject.ownedBy=localStorage.getItem("email");


    this.roomAmenitiesObject.ac = this.propertyFormGroup.value.ac;
    this.roomAmenitiesObject.cupboard = this.propertyFormGroup.value.cupboard;
    this.roomAmenitiesObject.tv = this.propertyFormGroup.value.tv;
    this.roomAmenitiesObject.geyser = this.propertyFormGroup.value.geyser;
    this.roomAmenitiesObject.bedding = this.propertyFormGroup.value.bedding;

    this.propertyObject.roomAmenities = this.roomAmenitiesObject;


    this.rulesObject.smoking = this.propertyFormGroup.value.smoking;
    this.rulesObject.girlsEntry = this.propertyFormGroup.value.girlsEntry;
    this.rulesObject.nonVeg = this.propertyFormGroup.value.nonVeg;
    this.rulesObject.drinking = this.propertyFormGroup.value.drinking;
    this.rulesObject.guardianStay = this.propertyFormGroup.value.guardianStay;

    this.propertyObject.rules = this.rulesObject;


    this.availableAmenitiesObject.commonTv = this.propertyFormGroup.value.commonTv;
    this.availableAmenitiesObject.powerBackup = this.propertyFormGroup.value.powerBackup;
    this.availableAmenitiesObject.wifi = this.propertyFormGroup.value.wifi;
    this.availableAmenitiesObject.gym = this.propertyFormGroup.value.gym;
    this.availableAmenitiesObject.refrigerator = this.propertyFormGroup.value.refrigerator;
    this.availableAmenitiesObject.lift = this.propertyFormGroup.value.lift;

    this.propertyObject.availableAmenities=this.availableAmenitiesObject;
    this.propertyObject.ownedBy=localStorage.getItem("email");

console.log("propertyobject ",this.propertyObject)

    // post Api

    this.proper.saveProperty(this.propertyObject, this.files[0]).subscribe((result) => {
      console.warn("result is here", result)
         this.propertyFormGroup.reset();
         this.nearByPlaces = [];
         this.router.navigate(['/home/properties']);
    })


  }


//image input
onFileChanged(files) {
  this.prepareFilesList(files);
}
prepareFilesList(files: Array<any>) {
  for (const item of files) {
    item.progress = 0;
    this.files.push(item);
  }
  this.uploadFilesSimulator(0);
}
uploadFilesSimulator(index: number) {
  setTimeout(() => {
    if (index === this.files.length) {
      return;
    } else {
      const progressInterval = setInterval(() => {
        if (this.files[index].progress === 100) {
          clearInterval(progressInterval);
          this.uploadFilesSimulator(index + 1);
        } else {
          this.files[index].progress += 5;
        }
      }, 200);
    }
  }, 1000);
}
formatBytes(bytes, decimals) {
  if (bytes === 0) {
    return '0 Bytes';
  }
  const k = 1024;
  const dm = decimals <= 0 ? 0 : decimals || 2;
  const sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];
  const i = Math.floor(Math.log(bytes) / Math.log(k));
  return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)) + ' ' + sizes[i];
}


//till here

// chip setup

addnearByPlace(event: MatChipInputEvent): void {
  const input = event.input;
  const value = event.value;
  if ((value || '').trim()) {
    this.nearByPlaces.push(value.trim());
  }
  if (input) {
    input.value = '';
  }
  this.nearByPlaceCtrl.setValue(null);
}

remove(nearByPlace: any): void {
  const index = this.nearByPlaces.indexOf(nearByPlace);
  if (index >= 0) {
    this.nearByPlaces.splice(index, 1);
  }
}
  selected(event: MatAutocompleteSelectedEvent): void {
    this.nearByPlaces.push(event.option.viewValue);
    this.nearByPlaceInput.nativeElement.value = '';
    this.nearByPlaceCtrl.setValue(null);
  }


  
}
