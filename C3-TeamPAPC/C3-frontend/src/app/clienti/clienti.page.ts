import { LoginService } from './../login.service';
import { LoginPage } from './../login/login.page';
import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../cliente.service';

@Component({
  selector: 'app-clienti',
  templateUrl: './clienti.page.html',
  styleUrls: ['./clienti.page.scss'],
})
export class ClientiPage implements OnInit {
  private _idNegozio:number;

  constructor(private clienteService:ClienteService) {}

  ngOnInit() {}

  
  public get idNegozio() : number {
    return this._idNegozio;
  }

  
  public set idNegozio(v : number) {
    this._idNegozio = v;
  }
  
  

  public setEmittenteToOrdine(){
    return this.clienteService.setEmittente(this._idNegozio).subscribe((data:string)=>{
      alert(data);
    });
  }


  public alertIdCliente(){
    alert(this.clienteService.sharedIdCliente);
  }

}
