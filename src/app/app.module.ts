import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AgregarComponent } from './components/agregar/agregar.component';
import { ConsultarComponent } from './components/consultar/consultar.component';
import { EliminarComponent } from './components/eliminar/eliminar.component';
import { HomeComponent } from './components/home/home.component';
import { PrestarComponent } from './components/prestar/prestar.component';

import { HttpClientModule } from '@angular/common/http';

import { FormsModule }   from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    AgregarComponent,
    ConsultarComponent,
    EliminarComponent,
    HomeComponent,
    PrestarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
