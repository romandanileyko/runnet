/**
 * Created by danil on 25.07.2017.
 */
import {Injectable} from "@angular/core";
import {Http, RequestOptions} from "@angular/http";
import {Headers} from '@angular/http'
@Injectable()
export class DashBoard{
  constructor(private http : Http){}

  getActiveClientCount(){
    let headers = new Headers({'Authorization':'' + localStorage.getItem('Authorization')});
    let options = new RequestOptions({headers:headers});
    return this.http.get('/active-client-count',options).map(res=>res.json())
  }

  getCountClient(){
    let headers = new Headers({'Authorization':'' + localStorage.getItem('Authorization')});
    let options = new RequestOptions({headers:headers});
    return this.http.get('/count-client',options).map(res=>res.json())
  }

  getLastRegistered(hostelNum,dayCount){
    let headers = new Headers({'Authorization':'' + localStorage.getItem('Authorization')});
    let options = new RequestOptions({headers:headers});
    return this.http.get('/last-registered?hostelNum='+hostelNum+'&dayCount='+dayCount,options)
      .map(res => res.json())
  }
}

