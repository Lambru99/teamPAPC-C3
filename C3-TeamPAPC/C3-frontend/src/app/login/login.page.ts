import { LoginService } from './../login.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {
  email:string;
  password:string;
  type:string;
  private _idUser:number;

  constructor(private loginService:LoginService,private route:Router) { }

  ngOnInit() {
  }

  
  public get idUser() : number {
    return this._idUser;
  }

  
  public set idUser(v : number) {
    this._idUser = v;
  }
  
  

  public loginVerify(){
    this.loginService.verifyLogin(this.type,this.email,this.password).subscribe((data:number)=>{
      this.idUser=data;
      this.loginService.setSharedId(data,this.type);
      //il metodo va messo dentro la lamda di subscribe, altrimenti il risultato non viene aggiornato
      this.controlloId(data);
    });
    
  }

  private controlloId(numero:number){
    if(numero==0) alert("hai sbagliato email e password, o non esiste un utente di questo tipo con questi parametri");
    else this.routeTypeOfUser();
  }

  private routeTypeOfUser():void{
    if(this.type=="cliente")this.route.navigate(['../clienti']);
  }

  public alertType() {
    alert(this.type);
  }

  public alertIdUser(){
    alert(this.idUser);
  }

}
