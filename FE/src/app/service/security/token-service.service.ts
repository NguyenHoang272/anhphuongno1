import { Injectable } from '@angular/core';
import { UserInformation } from '../../payload/response/user-information';

const TOKEN_KEY = 'Token_key';
const ROLE_KEY = 'Role_key';
const USER_INFORMATION_KEY = 'User_information_key';

@Injectable({
  providedIn: 'root'
})
export class TokenServiceService {

  roles = [];

  constructor() { }

  public setTokenLocal(token: string) {
    localStorage.removeItem(TOKEN_KEY);
    localStorage.setItem(TOKEN_KEY, token);
  }

  public setTokenSession(token: string) {
    sessionStorage.removeItem(TOKEN_KEY);
    sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string {
    if (localStorage.getItem(TOKEN_KEY) !== null) {
      return localStorage.getItem(TOKEN_KEY) as string;
    } else {
      return sessionStorage.getItem(TOKEN_KEY) as string;
    }
  }

  public setUserInformationLocal(userInformation: UserInformation) {
    localStorage.removeItem(USER_INFORMATION_KEY);
    localStorage.setItem(USER_INFORMATION_KEY, JSON.stringify(userInformation));
  }

  public setUserInformationSession(userInformation: UserInformation) {
    sessionStorage.removeItem(USER_INFORMATION_KEY);
    sessionStorage.setItem(USER_INFORMATION_KEY, JSON.stringify(userInformation));
  }

  public getUserInformation(): string {
    if (localStorage.getItem(USER_INFORMATION_KEY) !== null) {
      return localStorage.getItem(USER_INFORMATION_KEY);
    } else {
      return sessionStorage.getItem(USER_INFORMATION_KEY);
    }
  }

  public setRoleLocal(roles: string[]) {
    localStorage.removeItem(ROLE_KEY);
    localStorage.setItem(ROLE_KEY, JSON.stringify(roles));
  }

  public setRoleSession(roles: string[]) {
    sessionStorage.removeItem(ROLE_KEY);
    sessionStorage.setItem(ROLE_KEY, JSON.stringify(roles));
  }

  public getRole(): string[] {
    if (localStorage.getItem(ROLE_KEY) !== null) {
      JSON.parse(localStorage.getItem(ROLE_KEY)).forEach(role => {
        this.roles.push(role.authority);
      });
    } else {
      JSON.parse(sessionStorage.getItem(ROLE_KEY)).forEach(role => {
        this.roles.push(role.authority);
      });
    }

    return this.roles;
  }

  public logOut() {
    window.localStorage.clear();
    window.sessionStorage.clear();
  }

  public rememberMe(token: string, roles: string[], userInformation: UserInformation) {
    this.logOut();
    this.setRoleLocal(roles);
    this.setTokenLocal(token);
    this.setUserInformationLocal(userInformation);
  }

  public isLogged(): boolean {
    return !(window.sessionStorage.getItem(TOKEN_KEY) == null && window.localStorage.getItem(TOKEN_KEY) == null);
  }

}
