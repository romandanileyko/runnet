import { Component } from '@angular/core';
import {LoginService} from "./LoginService";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app works!!!';
  constructor(private auth:LoginService){}

  logout(){
    this.auth.logout();
  }
}
