import {Injectable} from "@angular/core";
import {CanActivate, Router} from "@angular/router";
import {LoginService} from "./LoginService";
/**
 * Created by danil on 17.07.2017.
 */
@Injectable()
export class AuthGuard implements CanActivate{

  constructor(private auth:LoginService,private router:Router){}

  canActivate(){
    if(this.auth.loggedIn()){
      return true;
    }
    else {
      this.router.navigateByUrl('/login');
      return false;
    }
  }
}
