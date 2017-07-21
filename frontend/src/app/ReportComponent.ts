import {Component} from "@angular/core";
import {Http, RequestOptions} from "@angular/http";
import {Headers} from '@angular/http'

/**
 * Created by danil on 17.07.2017.
 */

@Component({
  selector: 'secure',
  template:`<button (click)="getSecure()">Get</button>
            <p>{{text}}</p>`
})

export class ReportComponent{

  text: string;

  constructor(private auth:Http){}

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
}
