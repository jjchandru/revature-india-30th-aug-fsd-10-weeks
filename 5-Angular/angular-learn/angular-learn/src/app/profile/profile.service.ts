import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  usersUrl : string = "https://reqres.in/api/users/1";

  constructor(private httpClient : HttpClient) { }

  getUser(): Observable<any> {
    let observable : Observable<any> = this.httpClient.get<any>(this.usersUrl);
    return observable;
    //return this.httpClient.get<any>(this.usersUrl);
  }
}
