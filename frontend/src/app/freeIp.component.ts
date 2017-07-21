/**
 * Created by danil on 20.07.2017.
 */
import {FreeIpService} from "./freeIp.service";
import {Component, OnInit} from "@angular/core";

@Component({
  selector:'free-ip',
  templateUrl:'./freeip.component.html',
  providers:[FreeIpService]
})

export class FreeIpComponent implements OnInit{

  getData:any;

  constructor(private http: FreeIpService){}

  ngOnInit(){
      this.http.getData().subscribe(response => {this.getData =response},
        err => console.log(err),
        ()=> console.log(this.getData));
  }
}
