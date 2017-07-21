/**
 * Created by danil on 20.07.2017.
 */
import {Injectable} from "@angular/core";
import {Http, RequestOptions} from "@angular/http";
import {Headers} from '@angular/http'
@Injectable()
export class FreeIpService{

  constructor(private http : Http){}

  getData(){
    let headers = new Headers({'Authorization':'' + localStorage.getItem('Authorization')});
    let options = new RequestOptions({headers:headers});
    return this.http.get("/free-ip",options)
      .map(res=>res.json())
  }
}
