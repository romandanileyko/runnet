/**
 * Created by danil on 28.07.2017.
 */
import {Injectable} from "@angular/core";
import {Http, RequestOptions} from "@angular/http";
import {Headers} from '@angular/http'
@Injectable()
export class LogService{
  constructor(private http: Http){}

  getDhcpLogByLogin(login){
    let headers = new Headers({'Authorization':'' + localStorage.getItem('Authorization')});
    let options = new RequestOptions({headers:headers});
    return this.http.get("/dhcp-log-by-login?login="+login,options).map(res => res.json())
  }
}
