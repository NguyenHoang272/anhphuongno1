import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { LoginForm } from '../../payload/request/login-form';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(
    private httpClient: HttpClient
  ) { }

  login(loginForm: LoginForm): Observable<any> {
    return this.httpClient.post<any>(environment.API_URL + 'api/v1/security/login', loginForm);
  }

} 
