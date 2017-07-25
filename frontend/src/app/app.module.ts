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

const appRoutes: Routes =[
  {path:'',component:LoginComponent},
  {path:'login',component:LoginComponent},
  {path:'test',component:DashBoardComponent,canActivate:[AuthGuard]},
  {path:'about',component:AboutComponent},
  {path:'free-ip',component:FreeIpComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashBoardComponent,
    AboutComponent,
    FreeIpComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [LoginService,AuthGuard,FreeIpService,DashBoard],
  bootstrap: [AppComponent]
})
export class AppModule { }
