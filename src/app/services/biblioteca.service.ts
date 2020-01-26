import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class BibliotecaService {

  constructor(private _httpCliente: HttpClient) { }

  getQuery(query: string){
    const url = `http://localhost/${query}.php`;
    console.log(url);
    return url;
  }

  login(){
    
  }

  //post
  crearLibro(isbn:string, nombre:string){
    const headers = new HttpHeaders({'Content-Type':'application/x-www-form-urlencoded'});
    const body = {isbn, nombre};
    return this._httpCliente.post(this.getQuery('libro/crear') , {headers}, {params: body});
  }

  //get
  consultarLibro(isbn:string, nombre:string, estado:string){
    const headers = new HttpHeaders({isbn, nombre, estado});
    return this._httpCliente.get(this.getQuery('libro/consultar'), {headers});
  }

  //delete
  elimnarLibro(idLibro){
    const headers = new HttpHeaders({idLibro});
    return this._httpCliente.delete(this.getQuery('libro/eliminar'), {headers});
  }

  //put
  prestarlibro(idLibro, idUsuario){
    const headers = new HttpHeaders({idLibro, idUsuario});
    return this._httpCliente.put(this.getQuery('libro/prestar'), {headers});
  } 
   
  //get
  getUsuario(idUsuario, nombre){
    const headers = new HttpHeaders({idUsuario, nombre});
    return this._httpCliente.get(this.getQuery('usuario/consultar'), {headers})
  }

  
}
