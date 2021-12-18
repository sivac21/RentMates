import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import {  throwError, BehaviorSubject } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserAuthenticationManagementService {

  constructor( private httpClient: HttpClient) { }

  // apiBaseUrl = 'http://localhost:8888';
  apiBaseUrl = environment.apiBaseUrl + '/user-authentication-management-service';

  login(){
    console.log("it works!!!");
    window.open(this.apiBaseUrl+'/oauth2/authorization/google');
  }

  jwtLogin(data: User): Observable<User>{
    return this.httpClient.post<User>(this.apiBaseUrl+"/api/v1/loginuser",data)
    .pipe(catchError(this.errorHandler));

  }

  jwtRegister(data: User): Observable<User>{
    return this.httpClient.post<User>(this.apiBaseUrl+"/api/v1/register",data)
    .pipe(catchError(this.errorHandler));

      
  }

  public errorHandler(error: Response | any) {
    if (error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occured:', error.message);
      return throwError('Something bad happened');
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.message}` +
        error.error.error
      );
      return throwError(error);
    }
  }
}
