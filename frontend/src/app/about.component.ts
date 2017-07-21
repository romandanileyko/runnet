import {Component} from "@angular/core";
import {LoginService} from "./LoginService";
/**
 * Created by danil on 17.07.2017.
 */
@Component({
  selector: 'about',
  template:`<p>О программе.</p>`
})

export class AboutComponent {

  constructor(private auth: LoginService) {}

  logout(){
    this.auth.logout();
  }

}
