/**
 * Created by danil on 28.07.2017.
 */
import {Component} from "@angular/core";
import {LogService} from "./log.service";
@Component({
  selector: 'dhcpLog',
  templateUrl:'./log.component.html',
  providers:[LogService]
})

export class LogComponent{

  login: string;
  dhcpLogByLogin: any;

  constructor(private http: LogService){}

  getDhcpLogByLogin(login){
    this.http.getDhcpLogByLogin(login).subscribe(responce => {this.dhcpLogByLogin=responce},
    err => console.log(err),
    () => console.log(this.dhcpLogByLogin))
  }

}
