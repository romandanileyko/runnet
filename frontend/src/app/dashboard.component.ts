import {Component, OnInit} from "@angular/core";
import {Http, RequestOptions} from "@angular/http";
import {Headers} from '@angular/http'
import {DashBoard} from "./dashboard.service";
import { Response} from '@angular/http';
import {it} from "selenium-webdriver/testing";
import {CountClient} from "./countClient";
import {count} from "rxjs/operator/count";
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
  dataChart: number[] = [];
  dataLables:string[] = [];
  public isDataAvailable:boolean = false;


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
    this.http.getLastRegistered(hostelNum,dayCount).subscribe((reponse: Response) =>
        {
          this.lastRegistered = reponse;
        },
        err => console.log(err),
        () => console.log(this.lastRegistered))
  }

  ngOnInit(){
    this.http.getCountClient().subscribe((response:Response) => {
        this.countClient = response;

        let data:number[]=[];
        let lablel:string[]=[];

        for(let item in response){
          let coutClientObj = response[item];
          //this.dataLables.push(coutClientObj['nameOfHostel']);
          //this.dataChart.push(coutClientObj['countClient']);
          lablel.push(coutClientObj['nameOfHostel']);
          data.push(coutClientObj['countClient']);
        }
        this.dataChart = data;
        this.dataLables = lablel;
        this.isDataAvailable = true;
      },
      err => console.log(err),
      () => console.log(this.countClient))

    this.http.getActiveClientCount().subscribe(response => {this.activeClientCount =response}),
      err => console.log(err),
      () => console.log(this.activeClientCount)
  }

  // public doughnutChartLabels:string[] = this.dataLables;
  // public doughnutChartData:number[] = this.dataChart;
  public doughnutChartType:string = 'doughnut';

}
