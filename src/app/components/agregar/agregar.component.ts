import { Component, OnInit } from '@angular/core';
import { BibliotecaService } from '../../services/biblioteca.service';
import { Libro } from '../../models/libro'


@Component({
  selector: 'app-agregar',
  templateUrl: './agregar.component.html',
  styleUrls: ['./agregar.component.css']
})
export class AgregarComponent implements OnInit {

  public libro: Libro;  

  constructor(
     private _bibliotecaService: BibliotecaService
  ) { 
    this.libro = new Libro('', '');    
  }

  ngOnInit() {
  }

  onSubmit(agregarForm){
   this._bibliotecaService.crearLibro(this.libro.isbn, this.libro.nombre).subscribe();
  }

}
