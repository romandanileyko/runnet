import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {LoginComponent} from "./login.component";
import {LoginService} from "./LoginService";
import {RouterModule, Routes} from "@angular/router";
import {AboutComponent} from "./about.component";
import {DashBoardComponent} from "./dashboard.component";
import {AuthGuard} from "./AuthGuard";
import {FreeIpComponent} from "./freeIp.component";
import {FreeIpService} from "./freeIp.service";
import {DashBoard} from "./dashboard.service";
import {LogComponent} from "./log.component";
import {ChartsModule} from "ng2-charts";

const appRoutes: Routes =[
  {path:'',component:LoginComponent},
  {path:'login',component:LoginComponent},
  {path:'test',component:DashBoardComponent,canActivate:[AuthGuard]},
  {path:'about',component:AboutComponent},
  {path:'free-ip',component:FreeIpComponent},
  {path:'dhcp-log-by-login',component:LogComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashBoardComponent,
    AboutComponent,
    FreeIpComponent,
    LogComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    ChartsModule
  ],
  providers: [LoginService,AuthGuard,FreeIpService,DashBoard,LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
