import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { User } from '../utente';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.page.html',
  styleUrls: ['./registration.page.scss'],
})
export class RegistrationPage implements OnInit {
  private _user:User;
  private _cliente:Cliente;

  constructor() {
    this._user = new User();
   }

  
  public get user() : User {
    return this._user;
  }
  
  public get cliente() : Cliente {
    return this._cliente;
  }
  
  public set cliente(v : Cliente) {
    this._cliente = v;
  }
  
  
  
  public alertCliente():void {
    this.cliente = new Cliente();
    this.cliente.nome = this.user.nome;
    this.cliente.cognome = this.user.cognome;
    this.cliente.email = this.user.email;
    this.cliente.password = this.user.password;
    alert(this.cliente.toString());
  }

  ngOnInit() {
  }

}
