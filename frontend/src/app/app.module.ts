import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {LoginComponent} from "./login.component";
import {LoginService} from "./LoginService";
import {RouterModule, Routes} from "@angular/router";
import {AboutComponent} from "./about.component";
import {ReportComponent} from "./ReportComponent";
import {AuthGuard} from "./AuthGuard";
import {FreeIpComponent} from "./freeIp.component";
import {FreeIpService} from "./freeIp.service";

const appRoutes: Routes =[
  {path:'',component:LoginComponent},
  {path:'login',component:LoginComponent},
  {path:'test',component:ReportComponent,canActivate:[AuthGuard]},
  {path:'about',component:AboutComponent},
  {path:'free-ip',component:FreeIpComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ReportComponent,
    AboutComponent,
    FreeIpComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [LoginService,AuthGuard,FreeIpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
