/**
 * Created by danil on 20.07.2017.
 */
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
@Injectable()
export class FreeIpService{

  constructor(private http : Http){}

  getData(){
    return this.http.get("/free-ip")
      .map(res=>res.json())
  }
}
