import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private _sharedIdCliente:number;
  private url = "http://localhost:8080/clienti";
  private httpHeaders = new HttpHeaders({'Access-Control-Allow-Origin':'*'});

  constructor(private http:HttpClient) { }


  public setEmittente(numberId:number):Observable<any>{
    let idNegozio = numberId.toString();
    return this.http.post(this.url+"/setEmittente",null,{
      headers:this.httpHeaders,
      params:{idNegozio},
      responseType:'text'
    })
  }
  
  public get sharedIdCliente() : number {
    return this._sharedIdCliente;
  }

  
  public set sharedIdCliente(v : number) {
    this._sharedIdCliente = v;
  }
  
  

}
