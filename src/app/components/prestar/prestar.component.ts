import { Component, OnInit } from '@angular/core';
import { BibliotecaService } from '../../services/biblioteca.service';

@Component({
  selector: 'app-prestar',
  templateUrl: './prestar.component.html',
  styleUrls: ['./prestar.component.css']
})
export class PrestarComponent implements OnInit {

  usuarios: any[];
  libros: any[];

  constructor(
    private _bibliotecaService:BibliotecaService
  ) { }

  ngOnInit() {
  }
  
  buscarUsuarios(){
    this._bibliotecaService.getUsuario('', '').subscribe((response: any)=>{
      this.usuarios = response;
    });
  }

  buscarLibros(){
    this._bibliotecaService.consultarLibro('', '', '').subscribe((response: any)=>{
      console.log(response);
      //this.libros = response.data;
    });
  }

  prestarLibro(idLibro, idUsuario){
    this._bibliotecaService.prestarlibro(idLibro, idUsuario).subscribe((response: any)=>{
      console.log(response);
    })
  }
  
}
