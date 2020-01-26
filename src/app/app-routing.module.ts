import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AgregarComponent } from './components/agregar/agregar.component';
import { ConsultarComponent } from './components/consultar/consultar.component';
import { EliminarComponent } from './components/eliminar/eliminar.component';
import { HomeComponent } from './components/home/home.component';
import { PrestarComponent } from './components/prestar/prestar.component';
 

const routes: Routes = [
  {path:'home', component: HomeComponent}, 
  {path:'agregar', component: AgregarComponent},
  {path:'consultar', component: ConsultarComponent},
  {path:'eliminar', component: EliminarComponent},
  {path:'prestar', component: PrestarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
