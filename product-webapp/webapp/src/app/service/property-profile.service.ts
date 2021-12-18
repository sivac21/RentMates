import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PropertyProfileService {

  // apiBaseUrl = 'http://localhost:8090';
  apiBaseUrl = environment.apiBaseUrl + '/property-owner-service';

  url = "http://localhost:8090/api/v1/property";

  constructor(private http: HttpClient) { }

  getAllPropertyDetails() {
    throw new Error('Method not implemented.');
  }

  saveProperty(propertyObj: any, profileImage: File) {
    //console.warn("service",data)
    const data: FormData = new FormData();
    data.append('file', profileImage);
    data.append('property', JSON.stringify(propertyObj));
    return this.http.post(this.apiBaseUrl + "/api/v1/property", data)
  }

  getAllProperties() {
    return this.http.get<any>(this.apiBaseUrl + "/api/v1/properties");
  }

  getParticularPropertyDetails(propertyName) {
    return this.http.get(this.apiBaseUrl + "/api/v1/properties/" + propertyName);
  }


  getPropertyDetails() {
    return this.http.get("http://localhost:3000/propertys");
  }

  getAllPropertys() {
    return this.http.get("http://localhost:3000/propertys");
  }

  getSearchedProperties(search) {
    return this.http.get(this.apiBaseUrl + "/api/v1/search/" + search);
  }

}
