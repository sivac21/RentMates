import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { COMMA, ENTER } from '@angular/cdk/keycodes';
import { MatAutocompleteSelectedEvent } from '@angular/material/autocomplete';
import { MatChipInputEvent } from '@angular/material/chips';
import { TenantProfileService } from '../service/tenant-profile.service';
import { TenantProfile } from '../model/tenant-profile';
import { Router } from '@angular/router';
import { School } from '../model/school';
import { College } from '../model/college';
import { Career } from '../model/career';
import { Questionaire } from '../model/questionaire';
import { TenantMatchmakingServiceService } from '../service/tenant-matchmaking-service.service';


@Component({
  selector: 'app-update-tenant-profile',
  templateUrl: './update-tenant-profile.component.html',
  styleUrls: ['./update-tenant-profile.component.css']
})
export class UpdateTenantProfileComponent implements OnInit {

  files: any[] = [];

  visible: boolean = true;
  selectable: boolean = true;
  removable: boolean = true;
  addOnBlur: boolean = false;

  separatorKeysCodes = [ENTER, COMMA];

  hobbieCtrl = new FormControl();
  languageCtrl = new FormControl();

  hobbies = [
  ];

  languages = [
  ];


  @ViewChild('hobbieInput') hobbieInput: ElementRef;
  @ViewChild('languageInput') languageInput: ElementRef;

  tenantprofile: FormGroup;
  tenantProfileObject: TenantProfile = new TenantProfile();
  schoolObject: School = new School();
  collegeObject: College = new College();
  careerObject: Career = new Career();
  questionaireObject: Questionaire = new Questionaire();
  constructor(private tenant: FormBuilder, private tenantProfileService: TenantProfileService, private router: Router,
    private tenanMatchMakingService: TenantMatchmakingServiceService) { }

  ngOnInit(): void {
    this.tenantprofile = new FormGroup({
      fullName: new FormControl("", [Validators.required]),
      contactNumber: new FormControl("", [Validators.required]),
      age: new FormControl("", [Validators.required]),
      gender: new FormControl("", [Validators.required]),
      city: new FormControl("", [Validators.required]),
      state: new FormControl("", [Validators.required]),
      image: new FormControl(""),
      hobbies: new FormControl("", [Validators.required]),
      passion: new FormControl("", [Validators.required]),
      ambition: new FormControl("", [Validators.required]),
      language: new FormControl("", [Validators.required]),
      foodType: new FormControl("", [Validators.required]),
      smokeordrink: new FormControl("", [Validators.required]),
      maritalstatus: new FormControl("", [Validators.required]),
      careerstage: new FormControl("", [Validators.required]),
      schoolName: new FormControl(""),
      schoolgrade: new FormControl(""),
      schoolpassedout: new FormControl(""),
      collegeName: new FormControl(""),
      collegedegree: new FormControl(""),
      collegepassedout: new FormControl(""),
      companyName: new FormControl(""),
      profession: new FormControl(""),
      occupation: new FormControl(""),
      experience: new FormControl(""),
    });
  }

  saveProfile() {
    this.tenantProfileObject.fullName = this.tenantprofile.value.fullName;
    this.tenantProfileObject.contactNumber = this.tenantprofile.value.contactNumber;
    this.tenantProfileObject.age = this.tenantprofile.value.age;
    this.tenantProfileObject.gender = this.tenantprofile.value.gender;
    this.tenantProfileObject.city = this.tenantprofile.value.city;
    this.tenantProfileObject.state = this.tenantprofile.value.state;
    // this.tenantProfileObject.image = this.files[0];
    this.tenantProfileObject.hobbies = this.hobbies;
    this.tenantProfileObject.passion = this.tenantprofile.value.passion;
    this.tenantProfileObject.ambition = this.tenantprofile.value.ambition;

    this.questionaireObject.language = this.languages;
    this.questionaireObject.foodType = this.tenantprofile.value.foodType;
    this.questionaireObject.drinkingSmoking = this.tenantprofile.value.smokeordrink;
    this.questionaireObject.maritalStatus = this.tenantprofile.value.maritalstatus;
    this.tenantProfileObject.questionaire = this.questionaireObject;

    this.schoolObject.schoolName = this.tenantprofile.value.schoolName;
    this.schoolObject.grade = this.tenantprofile.value.schoolgrade;
    this.schoolObject.passedOut = this.tenantprofile.value.schoolpassedout;
    this.tenantProfileObject.school = this.schoolObject;

    this.collegeObject.collegeName = this.tenantprofile.value.collegeName;
    this.collegeObject.degree = this.tenantprofile.value.collegedegree;
    this.collegeObject.passedOut = this.tenantprofile.value.collegepassedout;
    this.tenantProfileObject.college = this.collegeObject;

    this.careerObject.companyName = this.tenantprofile.value.companyName;
    this.careerObject.profession = this.tenantprofile.value.profession;
    this.careerObject.occupation = this.tenantprofile.value.occupation;
    this.careerObject.experience = this.tenantprofile.value.experience;
    this.tenantProfileObject.career = this.careerObject;

    // this.tenantProfileObject.email = "maahi@gmail.com"; 

    // console.log('formvalue',this.tenantprofile.value);
    // console.log("Profile Object", this.tenantProfileObject);
    // this.tenantProfileService.createTenantProfile(this.tenantProfileObject).subscribe(data =>{
    //   console.log(data);
    //   this.tenantprofile.reset();
    //   this.languages = [];
    //   this.hobbies = [];
    // },
    // error => console.log(error));


    this.tenantProfileService.updateTenantProfile(this.tenantProfileObject, this.files[0], localStorage.getItem("email")).subscribe(data => {
      console.log("Successfuly Updated Tenant Profile", data);
      this.tenantprofile.reset();
      this.languages = [];
      this.hobbies = [];
      this.files = [];

    this.tenantProfileObject.email = localStorage.getItem('email');
    this.tenanMatchMakingService.createTenantMatchmakingNode(this.tenantProfileObject).subscribe(response => {
      console.log("Successfully post the Tenant", response);
      this.router.navigate(['/home/userprofile']);
    },
      error => { console.warn(error) });
  }
  ,
    error => console.warn(error));
  }

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

  addhobbie(event: MatChipInputEvent): void {
    const input = event.input;
    const value = event.value;

    if ((value || '').trim()) {
      this.hobbies.push(value.trim());
    }

    if (input) {
      input.value = '';
    }

    this.hobbieCtrl.setValue(null);
  }

  addlang(event: MatChipInputEvent): void {
    const input = event.input;
    const value = event.value;

    if ((value || '').trim()) {
      this.languages.push(value.trim());
    }

    if (input) {
      input.value = '';
    }

    this.languageCtrl.setValue(null);
  }

  remove(hobbie: any): void {
    const index = this.hobbies.indexOf(hobbie);

    if (index >= 0) {
      this.hobbies.splice(index, 1);
    }
  }

  removelang(language: any): void {
    const index = this.languages.indexOf(language);

    if (index >= 0) {
      this.languages.splice(index, 1);
    }
  }

  selected(event: MatAutocompleteSelectedEvent): void {
    this.hobbies.push(event.option.viewValue);
    this.hobbieInput.nativeElement.value = '';
    this.hobbieCtrl.setValue(null);
  }

  selectedlang(event: MatAutocompleteSelectedEvent): void {
    this.languages.push(event.option.viewValue);
    this.languageInput.nativeElement.value = '';
    this.languageCtrl.setValue(null);
  }

}
