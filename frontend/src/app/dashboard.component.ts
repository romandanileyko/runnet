import {Component, OnInit} from "@angular/core";
import {Http, RequestOptions} from "@angular/http";
import {Headers} from '@angular/http'
import {DashBoard} from "./dashboard.service";

/**
 * Created by danil on 17.07.2017.
 */

@Component({
  selector: 'secure',
  templateUrl:'./dashboard.component.html',
  providers:[DashBoard]
})

export class DashBoardComponent implements OnInit{

  text: string;
  countClient: any;
  activeClientCount: any;

  constructor(private auth:Http,private http:DashBoard){}

  getSecure(){
    let headers = new Headers({'Authorization':'' + localStorage.getItem('Authorization')});
    let options = new RequestOptions({headers:headers});
    console.log(localStorage.getItem('Authorization'))
    this.auth.get('/test',options)
      .map(res =>res.json())
      .subscribe(
        data => this.text= data,
        error => console.log(error)
      );
  }

  ngOnInit(){
    this.http.getCountClient().subscribe(response => {this.countClient = response},
      err => console.log(err),
      () => console.log(this.countClient))

    this.http.getActiveClientCount().subscribe(response => {this.activeClientCount =response}),
      err => console.log(err),
      () => console.log(this.activeClientCount)
  }
}
