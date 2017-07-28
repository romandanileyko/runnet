import {Component, OnInit} from "@angular/core";
import {Http, RequestOptions} from "@angular/http";
import {Headers} from '@angular/http'
import {DashBoard} from "./dashboard.service";
import {GoogleChartComponent} from "ng2-google-charts";
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
  lastRegistered: any;
  hosteNum: number;
  dayCount: number;

  pieChartData = {
    chartType: 'PieChart',
    dataTable: [
      ['Task', 'Hours per Day'],
      ['Work',     11],
      ['Eat',      2],
      ['Commute',  2],
      ['Watch TV', 2],
      ['Sleep',    7]
    ],
    options: {'title': 'Tasks'},
  };

  hostelsList = [1,2,3,5,6,7,10,11,12,13,14,15,16,17,19,20];

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

  getLastRegistered(hostelNum,dayCount){
    this.http.getLastRegistered(hostelNum,dayCount).subscribe(reponse => {this.lastRegistered = reponse},
        err => console.log(err),
        () => console.log(this.lastRegistered))
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
