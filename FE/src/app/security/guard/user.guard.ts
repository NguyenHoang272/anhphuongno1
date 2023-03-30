import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Observable } from 'rxjs';
import { TokenServiceService } from 'src/app/service/security/token-service.service';

@Injectable({
  providedIn: 'root'
})
export class UserGuard implements CanActivate {

  roles: string[];
  isLogged: boolean = false;

  constructor(
    private tokenService: TokenServiceService,
    private toastr: ToastrService,
    private router: Router
  ) {
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    this.isLogged = this.tokenService.isLogged();

    if(this.isLogged) {
      return true;
    } else {
      this.toastr.warning('Bạn không có quyền vào trang này')
      this.router.navigateByUrl('');
    }

  }
  
}
